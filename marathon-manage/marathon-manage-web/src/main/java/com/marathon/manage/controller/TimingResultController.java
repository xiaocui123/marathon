/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.marathon.manage.controller;

import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.marathon.manage.qvo.TimingResultQO;
import com.marathon.manage.refactor.pojo.PointsFLow;
import com.marathon.manage.refactor.pojo.RaceCatMaster;
import com.marathon.manage.refactor.pojo.RunnerInfo;
import com.marathon.manage.refactor.pojo.RunnerInfoExample;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;
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

    @RequestMapping("/queryAction")
    @ResponseBody
    public Page<Map<String, Object>> queryAciton(HttpServletRequest request, @RequestBody TimingResultQO qo) {
        Page<Map<String, Object>> result = timingResultService.queryForAll(qo, qo.getOffset(), qo.getLimit());
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
    private void rebuildCatInfo(List<Map<String, Object>> result) {

        for (Map<String, Object> resultt : result) {
            String cat = (String) resultt.get(TimingConstants.DEFAULT_RESULT_TABLE_COLUMNS[0]);
            if (!Strings.isNullOrEmpty(cat)) {
                try {
                    cat = raceCatCache.getCatChinese(cat);
                } catch (ExecutionException e) {
                    logger.error("cat parse errro", e);
                }
                resultt.put(TimingConstants.DEFAULT_RESULT_TABLE_COLUMNS[0], cat);
            }
        }
    }
}
