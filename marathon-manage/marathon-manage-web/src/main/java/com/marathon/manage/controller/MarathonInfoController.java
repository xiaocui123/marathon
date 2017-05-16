package com.marathon.manage.controller;

import com.marathon.manage.MarathonConstants;
import com.marathon.manage.pojo.MarathonInfo;
import com.marathon.manage.service.MarathonInfoService;
import com.marathon.manage.vo.JSONResult;
import com.marathon.manage.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by cui on 2017/5/16.
 */
@Controller
@RequestMapping("marathon")
public class MarathonInfoController {

    @Autowired
    private MarathonInfoService marathonInfoService;

    @RequestMapping("init")
    public String init() {
        return "marathon/marathonInfo";
    }

    @RequestMapping("/add")
    @ResponseBody
    public JSONResult addMarathon(@RequestBody MarathonInfo marathonInfo, HttpServletRequest request) {
        JSONResult result = new JSONResult();
        String userId = (String) request.getSession().getAttribute(MarathonConstants.SYSTEM_USER_ID);
        userId="test";
        marathonInfo.setMarathonCreater(userId);
        marathonInfoService.addMarathon(marathonInfo);
        return result;
    }

    @RequestMapping("query")
    @ResponseBody
    public Page<MarathonInfo> query(@RequestBody Page<MarathonInfo> page) {
        marathonInfoService.queryForAll(page);
        return page;
    }
}
