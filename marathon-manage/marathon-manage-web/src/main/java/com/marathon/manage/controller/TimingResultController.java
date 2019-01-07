/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.marathon.manage.controller;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.marathon.manage.qvo.ResultDetailVO;
import com.marathon.manage.qvo.TimingResultQO;
import com.marathon.manage.refactor.pojo.*;
import com.marathon.manage.service.TimingResultService;
import com.marathon.manage.vo.BaseResultBean;
import com.marathon.manage.vo.Page;
import com.marathon.manage.vo.ResultEnum;
import com.marathon.manage.vo.SimpleResultBean;
import com.marathon.timing.RaceCatCache;
import com.marathon.timing.TimingConstants;
import com.marathon.timing.service.CttimeService;
import com.marathon.timing.service.RunnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ExecutionException;

/**
 * @author cui
 * @version TimingResultController, v0.1 2018/12/24 10:01
 */
@Controller
@RequestMapping("timing")
public class TimingResultController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CttimeService cttimeService;

    @Autowired
    private RunnerService runnerService;

    @Autowired
    private TimingResultService timingResultService;

    @Autowired
    private RaceCatCache raceCatCache;

    @RequestMapping("/init")
    public String init(HttpServletRequest request) {
        return "timing/timingResult";
    }

    @RequestMapping("/getColumns")
    @ResponseBody
    public List<String> getColumns(HttpServletRequest request) {
        return cttimeService.getColumns();
    }

    @RequestMapping("/calcAndSaveResult")
    @ResponseBody
    public void calcAndSaveResult(HttpServletRequest request) {

        if (timingResultService.existTable(TimingConstants.DEFAULT_RESULT_TABLE_NAME)) {
            timingResultService.dropTable(TimingConstants.DEFAULT_RESULT_TABLE_NAME);
        }
        //创建结果表
        List<String> arrayColumn = cttimeService.getColumns();
        timingResultService.createTimingResult(TimingConstants.DEFAULT_RESULT_TABLE_NAME, arrayColumn);

        //分比赛类型计算排名
        Map<Integer, List<String>> courseCatMap = cttimeService.getCourseCats();
        for (Map.Entry<Integer, List<String>> entry : courseCatMap.entrySet()) {
            Integer courseID = entry.getKey();

            List<String> lstCat = entry.getValue();

            List<PointsFLow> lstPointFlow = cttimeService.getPointFlow(courseID);

            for (String cat : lstCat) {
                RunnerInfoExample example = new RunnerInfoExample();
                example.or().andCatEqualTo(cat);
                List<RunnerInfo> lstRunner = runnerService.queryRunners(example);

                List<Map<String, Object>> lstRunnerResult = Lists.newArrayList();
                for (RunnerInfo runnerInfo : lstRunner) {
                    Map<String, Object> objectMap = cttimeService.calcResult(runnerInfo, lstPointFlow, courseID);
                    objectMap.put("Cat", runnerInfo.getCat());
                    objectMap.put("Bib", runnerInfo.getBib());
//                    objectMap.put("NameChi", runnerInfo.getNamechi());
//                    objectMap.put("NameEng", runnerInfo.getNameeng());
                    objectMap.put("Gender", runnerInfo.getGender());
                    objectMap.put("Phone", runnerInfo.getPhone());

                    Integer cleanScore = calcCleanScore(objectMap, lstPointFlow);
                    if (cleanScore != null) {
                        objectMap.put(TimingConstants.SCORE_CLEAN, cleanScore);
                    }
                    Integer gunScore = calcGunScore(objectMap, lstPointFlow, courseID);
                    if (gunScore != null) {
                        objectMap.put(TimingConstants.SCORE_GUN, gunScore);
                    }

                    lstRunnerResult.add(objectMap);
                }

                List<Map<String, Object>> lstSortedResult = timingResultService.sortResult(lstPointFlow, lstRunnerResult);

                for (Map<String, Object> result : lstSortedResult) {
                    Map<String, String> copyMap = Maps.transformValues(result, new Function<Object, String>() {
                        @Override
                        public String apply(Object o) {
                            return String.valueOf(o);
                        }
                    });
                    timingResultService.saveResult(TimingConstants.DEFAULT_RESULT_TABLE_NAME, copyMap);
                }
                logger.info("**************Cat=【{}】计算跑者数量【{}】", cat, lstRunnerResult.size());
            }
        }

    }

    private Integer calcCleanScore(Map<String, Object> objectMap, List<PointsFLow> lstPointFlow) {
        final String startKey = lstPointFlow.get(0).getPoints();
        final String finishKey = lstPointFlow.get(lstPointFlow.size() - 1).getPoints();

        Integer startTime = (Integer) objectMap.get(startKey);
        Integer finishTime = (Integer) objectMap.get(finishKey);
        if (startTime != null && finishTime != null) {
            return finishTime - startTime;
        }
        return null;
    }

    private Integer calcGunScore(Map<String, Object> objectMap, List<PointsFLow> lstPointFlow, Integer courseID) {
        final String finishKey = lstPointFlow.get(lstPointFlow.size() - 1).getPoints();
        Integer finishTime = (Integer) objectMap.get(finishKey);
        if (finishTime != null) {
            RaceGunInfo raceGunInfo = cttimeService.getRaceGunInfo(courseID);
            if (raceGunInfo == null) {
                logger.error("courceId=【{}】的发枪时间未设置", courseID);
                return null;
            } else {
                return finishTime - Integer.valueOf(raceGunInfo.getGuntime());
            }
        } else {
            return null;
        }
    }

    @RequestMapping("/queryAction")
    @ResponseBody
    public Page<TimingFinalResultType> queryAciton(HttpServletRequest request, @RequestBody TimingResultQO qo) {
        Page<TimingFinalResultType> result = timingResultService.queryForAll(qo, qo.getOffset(), qo.getLimit());
        rebuildCatInfo(result.getRows());
        return result;
    }

    @RequestMapping("/queryAllCats")
    @ResponseBody
    public BaseResultBean queryAllCats() {
        SimpleResultBean<List<RaceCatMaster>> result = new SimpleResultBean<>();
        try {
            result.setObject(raceCatCache.getRaceCats());
        } catch (Exception e) {
            result.setEnum(ResultEnum.ERROR);
        }
        return result;
    }

    /**
     * 比赛类型转义
     *
     * @param result
     */
    private void rebuildCatInfo(List<TimingFinalResultType> result) {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        for (TimingFinalResultType resultt : result) {
            String cat = resultt.getCat();
            if (!Strings.isNullOrEmpty(cat)) {
                try {
                    cat = raceCatCache.getCatChinese(cat);
                } catch (ExecutionException e) {
                    logger.error("cat parse errro", e);
                }
                resultt.setCat(cat);
            }

            if (!Strings.isNullOrEmpty(resultt.getGunScore())) {
                resultt.setGunScore(format.format(Integer.valueOf(resultt.getGunScore())));
            }
            if (!Strings.isNullOrEmpty(resultt.getCleanScore())) {
                resultt.setCleanScore(format.format(Integer.valueOf(resultt.getCleanScore())));
            }
        }
    }


    /**
     * 获取结果的详细信息
     *
     * @param request
     * @param tag
     */
    @RequestMapping("resultDetail/{tag}")
    @ResponseBody
    public BaseResultBean resultDetail(HttpServletRequest request, @PathVariable(value = "tag") String tag) {
        SimpleResultBean<List<ResultDetailVO>> resultBean = new SimpleResultBean<>();
        List<CttimesInfo> lstCttimeInfo = cttimeService.getMeasuredRecordByTag(tag);
        Map<String, Object> result = timingResultService.getResultByTag(tag);

        List<ResultDetailVO> lstResultDetail = Lists.transform(lstCttimeInfo, new Function<CttimesInfo, ResultDetailVO>() {
            @Override
            public ResultDetailVO apply(CttimesInfo cttimesInfo) {
                ResultDetailVO vo = new ResultDetailVO();
                vo.setTime(cttimesInfo.getTime());
                vo.setReader(cttimesInfo.getReader());
                vo.setLocation(cttimesInfo.getLocation());
                vo.setLap(cttimesInfo.getLap());
                try {
                    long now = System.currentTimeMillis();
                    SimpleDateFormat sdfOne = new SimpleDateFormat("yyyy-MM-dd");
                    long unixZero = sdfOne.parse(sdfOne.format(now)).getTime();
                    long copy = unixZero + Integer.valueOf(vo.getTime());
                    SimpleDateFormat sdfTwo = new SimpleDateFormat("HH:mm:ss");
                    vo.setFormatTime(sdfTwo.format(copy));
                } catch (ParseException e) {
                    logger.error("获取北京时间失败！", e);
                }
                return vo;
            }
        });

        List<ResultDetailVO> clonedLstResultDetail=Lists.newArrayList();

        //标识点位信息
        for(ResultDetailVO resultDetail:lstResultDetail){
            if(result.values().contains(resultDetail.getTime())){
                Iterator entries = result.entrySet().iterator();
                while (entries.hasNext()) {
                    Map.Entry entry = (Map.Entry) entries.next();
                    String key = (String)entry.getKey();
                    String value = (String)entry.getValue();
                    if(value.equalsIgnoreCase(resultDetail.getTime())){
                        resultDetail.setMark(key);
                        break;
                    }
                }
            }
            clonedLstResultDetail.add(resultDetail);
        }
        resultBean.setObject(clonedLstResultDetail);
        return resultBean;
    }
}
