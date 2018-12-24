/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.marathon.manage.controller;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.marathon.manage.refactor.pojo.RunnerInfo;
import com.marathon.manage.service.TimingResultService;
import com.marathon.manage.vo.Page;
import com.marathon.timing.TimingConstants;
import com.marathon.timing.service.CttimeService;
import com.marathon.timing.service.RunnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author cui
 * @version TimingResultController, v0.1 2018/12/24 10:01
 */
@Controller
@RequestMapping("timing")
public class TimingResultController {

    @Autowired
    private CttimeService cttimeService;

    @Autowired
    private RunnerService runnerService;

    @Autowired
    private TimingResultService timingResultService;

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

        List<RunnerInfo> lstRunner = runnerService.queryAllRunners();
        for (RunnerInfo runnerInfo : lstRunner) {
            Map<String, Object> objectMap = cttimeService.calcResult(runnerInfo);
            objectMap.put("Cat", runnerInfo.getCat());
            objectMap.put("Bib", runnerInfo.getBib());
            objectMap.put("NameChi", runnerInfo.getNamechi());
            objectMap.put("NameEng", runnerInfo.getNameeng());
            objectMap.put("Gender", runnerInfo.getGender());
            objectMap.put("Phone", runnerInfo.getPhone());

            Map<String, String> copyMap = Maps.transformValues(objectMap, new Function<Object, String>() {
                @Override
                public String apply(Object o) {
                    return String.valueOf(o);
                }
            });
            timingResultService.saveResult(TimingConstants.DEFAULT_RESULT_TABLE_NAME, copyMap);
        }
    }

    @RequestMapping("/queryAction")
    @ResponseBody
    public Page<Map<String, Object>> queryAciton(HttpServletRequest request, @RequestBody Page<Map<String,Object>> qo) {
        timingResultService.queryForAll(qo);
        return qo;
    }
}
