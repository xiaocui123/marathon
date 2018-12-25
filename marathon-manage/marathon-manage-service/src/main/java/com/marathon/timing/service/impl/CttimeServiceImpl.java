/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.marathon.timing.service.impl;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.marathon.manage.refactor.mapper.*;
import com.marathon.manage.refactor.pojo.*;
import com.marathon.timing.TimingConstants;
import com.marathon.timing.excel.DataSet2ExcelSXSSFHelper;
import com.marathon.timing.excel.IValueFormatter;
import com.marathon.timing.service.CttimeService;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author cui
 * @version CttimeServiceImpl, v0.1 2018/12/12 9:43
 */
@Service
public class CttimeServiceImpl implements CttimeService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CttimesInfoMapper cttimesInfoMapper;

    @Autowired
    private PointsFLowMapper pointsFLowMapper;

    @Autowired
    private RunnerInfoMapper runnerInfoMapper;

    @Autowired
    private RaceGunInfoMapper raceGunInfoMapper;

    @Autowired
    private TimingResultMapper timingResultMapper;

    @Override
    public List<PointsFLow> getPointFlow() {
        PointsFLowExample example = new PointsFLowExample();
        example.or().andCourseidEqualTo(1);
        example.setOrderByClause(TimingConstants.POINTFLOW_ORDER_BY_KEY);
        return pointsFLowMapper.selectByExample(example);
    }

    @Override
    public void saveResult2Excel() {
        SXSSFWorkbook workbook = new SXSSFWorkbook(SXSSFWorkbook.DEFAULT_WINDOW_SIZE);

        RunnerInfoExample example = new RunnerInfoExample();
        example.setOrderByClause(TimingConstants.RUNNER_ORDER_BY_KEY);
        List<RunnerInfo> lstRunner = runnerInfoMapper.selectByExample(example);

        List<PointsFLow> lstFlow = getPointFlow();
        Preconditions.checkArgument(lstFlow.size() > 0, "流程未配置！");

        RaceGunInfo raceGunInfo = getRaceGunInfo();
        Preconditions.checkArgument(raceGunInfo != null, "发枪时间未配置！");

        List<Map<String, Object>> lstResult = Lists.newArrayList();

        for (RunnerInfo runnerInfo : lstRunner) {
            try {
                Map<String, Object> objectMap = calcRunnerRealTimePassLocation(runnerInfo, lstFlow, raceGunInfo);
                lstResult.add(objectMap);
            } catch (Exception e) {
                logger.error("计算【{}】的结果出错", runnerInfo.getNameeng(), e);
            }
        }

        //便于查看，增加显示标准时间字段
        boolean showBeijingTime = true;

        //计算净成绩，并按净成绩排序
        sortResult(lstFlow, lstResult);

        DataSet2ExcelSXSSFHelper helper = new DataSet2ExcelSXSSFHelper();
        Map<String, String> beanPropertyColumnMap = buildMap(lstFlow, showBeijingTime);

        Map<String, IValueFormatter> valueFormatterMap = Maps.newHashMap();
        if (showBeijingTime) {
            valueFormatterMap = buildValueFormatterMap(lstFlow);
        }


        helper.export(workbook, "计时结果", beanPropertyColumnMap, valueFormatterMap, lstResult);

        String fileName = "比赛结果" + TimingConstants.UNDERLINE + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + TimingConstants.EXCEL_EXT_XLSX;

        try {
            FileOutputStream fileOut = new FileOutputStream(fileName);
            workbook.write(fileOut);
            fileOut.close();
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 更新排名信息
     *
     * @param lstFlow
     * @param lstResult
     */
    private void sortResult(List<PointsFLow> lstFlow, List<Map<String, Object>> lstResult) {

        final String startKey = lstFlow.get(0).getPoints();

        final String finishKey = lstFlow.get(lstFlow.size() - 1).getPoints();

        for (Map<String, Object> objectMap : lstResult) {
            Integer o1StartTime = (Integer) objectMap.get(startKey);
            Integer o1finishTime = (Integer) objectMap.get(finishKey);

            if (o1StartTime != null && o1finishTime != null) {
                objectMap.put(TimingConstants.DEFAULT_RANK_KEY, o1finishTime - o1StartTime);
            } else {
                objectMap.put(TimingConstants.DEFAULT_RANK_KEY, null);
            }
        }

        Collections.sort(lstResult, new Comparator<Map<String, Object>>() {
            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                Integer o1Rank = (Integer) o1.get(TimingConstants.DEFAULT_RANK_KEY);
                Integer o2Rank = (Integer) o2.get(TimingConstants.DEFAULT_RANK_KEY);
                if (o1Rank == null && o2Rank == null)
                    return 0;
                if (o1Rank == null)
                    return 1;
                if (o2Rank == null)
                    return -1;
                return o1Rank - o2Rank;
            }
        });
    }

    private RaceGunInfo getRaceGunInfo() {

        List<RaceGunInfo> lstRaceInfo = raceGunInfoMapper.selectByExample(new RaceGunInfoExample());

        if (lstRaceInfo.size() > 0) {
            RaceGunInfo raceGunInfo = lstRaceInfo.get(0);
            if (!Strings.isNullOrEmpty(raceGunInfo.getPlannedguntime()) && !Strings.isNullOrEmpty(raceGunInfo.getGuntime())) {
                return raceGunInfo;
            }
        }

        return null;

    }

    /**
     * 生成字段与属性对应关系
     *
     * @param lstFlow
     * @param showBeijingTime：是否显示转换成北京时间，并添加到excel表头中
     * @return
     */
    private Map<String, String> buildMap(List<PointsFLow> lstFlow, boolean showBeijingTime) {
        Map<String, String> columnMap = Maps.newLinkedHashMap();
        columnMap.put("Tag", "Tag");
        for (PointsFLow pointsFLow : lstFlow) {
            columnMap.put(pointsFLow.getPoints(), pointsFLow.getPoints());
            if (showBeijingTime) {
                columnMap.put(TimingConstants.BEIJINGTIME_COLUMN_PREFIX + pointsFLow.getPoints(), pointsFLow.getPoints());
            }
        }
        columnMap.put(TimingConstants.DEFAULT_RANK_KEY, TimingConstants.DEFAULT_RANK_KEY);
        return columnMap;
    }

    /**
     * 显示数据格式转换器
     *
     * @param lstFlow
     * @return
     */
    private Map<String, IValueFormatter> buildValueFormatterMap(List<PointsFLow> lstFlow) {

        Map<String, IValueFormatter> valueFormatterMap = Maps.newHashMap();

        IValueFormatter formatter = new IValueFormatter() {
            @Override
            public String format(Object object) {
                if (object instanceof Integer) {
                    try {
                        Integer timeStamp = (Integer) object;
                        long now = System.currentTimeMillis();
                        SimpleDateFormat sdfOne = new SimpleDateFormat("yyyy-MM-dd");
                        long unixZero = sdfOne.parse(sdfOne.format(now)).getTime();
                        long copy = unixZero + timeStamp;
                        SimpleDateFormat sdfTwo = new SimpleDateFormat("HH:mm:ss SSS");
                        return sdfTwo.format(copy);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                return null;
            }
        };

        for (PointsFLow pointsFLow : lstFlow) {
            String pointName = pointsFLow.getPoints();
            String columnName = TimingConstants.BEIJINGTIME_COLUMN_PREFIX + pointName;
            valueFormatterMap.put(columnName, formatter);
        }

        //计算净成绩
        valueFormatterMap.put(TimingConstants.DEFAULT_RANK_KEY, formatter);

        return valueFormatterMap;
    }


    @Override
    public Map<String, Object> calcResult(RunnerInfo runner) {

        List<PointsFLow> lstFlow = getPointFlow();
        Preconditions.checkArgument(lstFlow.size() > 0, "流程未配置！");

        RaceGunInfo raceGunInfo = getRaceGunInfo();
        Preconditions.checkArgument(raceGunInfo != null, "发枪时间未配置！");

        Map<String, Object> objectMap = calcRunnerRealTimePassLocation(runner, lstFlow, raceGunInfo);

        return objectMap;

    }

    @Override
    public List<String> getColumns() {
        List<String> columns = Lists.newArrayList();
        columns.addAll(Arrays.asList(TimingConstants.DEFAULT_RESULT_TABLE_COLUMNS));
        List<PointsFLow> lstPoint = getPointFlow();
        columns.addAll(Lists.transform(lstPoint, new Function<PointsFLow, String>() {
            @Override
            public String apply(PointsFLow pointsFLow) {
                return pointsFLow.getPoints();
            }
        }));
        return columns;
    }

    @Override
    public Map<String, Object> calcRunnerRealTimePassLocation(RunnerInfo runnerInfo, List<PointsFLow> pointsFLows, RaceGunInfo raceGunInfo) {
        Map<String, Object> result = Maps.newHashMap();

        Integer tag = runnerInfo.getTag();

        if (tag == null) {
            throw new IllegalArgumentException("runner 【" + runnerInfo.getNamechi() + "】没有Tag信息！");
        }
        result.put("Tag", tag);

        CttimesInfoExample example = new CttimesInfoExample();
        example.or().andTagEqualTo(String.valueOf(tag));
        example.setOrderByClause(TimingConstants.CTTIME_ORDER_BY_KEY);

        List<CttimesInfo> lstTimes = cttimesInfoMapper.selectByExample(example);
        if (lstTimes == null || lstTimes.size() <= 0) {
            logger.error("runner 【" + runnerInfo.getNameeng() + "】没有采集到数据！");
            return result;
        }

        //发枪时间
        Integer dividingTime = Integer.valueOf(raceGunInfo.getGuntime()) + Integer.valueOf(raceGunInfo.getCutoffoffset());

        for (PointsFLow points : pointsFLows) {

            try {
                if (points.getSeq() == 1) {
                    //处理始发点，要选择最后一次感应到的时间
                    Integer time = getFirstLocationTime(lstTimes, points, false, dividingTime);
                    if (time != null) {
                        result.put(points.getPoints(), time);
                    }
                } else if (points.getSeq() == pointsFLows.size()) {
                    //处理终点，将时间列表倒置
                    List<CttimesInfo> reversedLstTimes = Lists.reverse(lstTimes);
                    Integer time = getFirstLocationTime(reversedLstTimes, points, true, dividingTime);
                    if (time != null && time > dividingTime) {
                        result.put(points.getPoints(), time);
                    }

                } else if (!Strings.isNullOrEmpty(points.getPriorpoint())) {
                    //这一点被通过多于一次，且不是第一次
                    Integer time = getMutiPassLocationTime(lstTimes, points);
                    if (time != null) {
                        result.put(points.getPoints(), time);
                    }
                } else {
                    //其他情况取最早感应的时间即可
                    Integer time = getCommonLocationTime(lstTimes, points);
                    if (time != null) {
                        result.put(points.getPoints(), time);
                    }
                }
            } catch (Exception e) {
                logger.error("计算Location【{}】时间时出错,reason【{}】", points.getDevice(), e.getMessage());
            }
        }
        return result;
    }


    private Integer getFirstLocationTime(List<CttimesInfo> lstTimes, PointsFLow points, boolean isReverse, Integer dividingTime) {
        String result = "";
        for (CttimesInfo time : lstTimes) {
            if (time.getLocation().equals(points.getDevice())) {
                //处理没有其他点数据的情况，起点数据和终点数据混在一起的情况
                if (!isReverse) {
                    if (Integer.valueOf(time.getTime()) < dividingTime) {
                        result = time.getTime();
                    } else {
                        break;
                    }
                } else {
                    if (Integer.valueOf(time.getTime()) > dividingTime) {
                        result = time.getTime();
                    } else {
                        break;
                    }
                }
            } else {
                break;
            }
        }
        return Integer.valueOf(result);
    }

    private Integer getCommonLocationTime(List<CttimesInfo> lstTimes, final PointsFLow points) {
        List<CttimesInfo> lstResult = Lists.newArrayList(Iterators.filter(lstTimes.iterator(), new Predicate<CttimesInfo>() {
            @Override
            public boolean apply(CttimesInfo cttimesInfo) {
                return cttimesInfo.getLocation().equals(points.getDevice());
            }
        }));
        return lstResult.size() > 0 ? Integer.valueOf(lstResult.get(0).getTime()) : null;
    }

    private Integer getMutiPassLocationTime(List<CttimesInfo> lstTimes, final PointsFLow points) {
        PointsFLow priorpoint = new PointsFLow();
        priorpoint.setPoints(points.getPriorpoint());
        priorpoint.setDevice(points.getPriorpoint());

        //获取前一Location时间
        final Integer priorpointFirstTime = getCommonLocationTime(lstTimes, priorpoint);
        if (priorpointFirstTime == null) {
            throw new IllegalArgumentException("runner 【" + lstTimes.get(0).getTag() + "】在点【" + priorpoint.getPoints() + "】处没有采集数据！");
        }

        List<CttimesInfo> lstResult = Lists.newArrayList(Iterators.filter(lstTimes.iterator(), new Predicate<CttimesInfo>() {
            @Override
            public boolean apply(CttimesInfo cttimesInfo) {
                return cttimesInfo.getLocation().equals(points.getDevice()) && Integer.valueOf(cttimesInfo.getTime()) > priorpointFirstTime;
            }
        }));
        return lstResult.size() > 0 ? Integer.valueOf(lstResult.get(0).getTime()) : null;
    }
}
