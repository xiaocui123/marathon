package com.marathon.manage.controller;

import com.marathon.manage.pojo.MarathonInfo;
import com.marathon.manage.pojo.MarathonMediaActivity;
import com.marathon.manage.qvo.MediaActivityQO;
import com.marathon.manage.service.MarathonInfoService;
import com.marathon.manage.service.MediaActivityService;
import com.marathon.manage.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by cui on 2017/5/17.
 */
@Controller
@RequestMapping("mediaactivity")
public class MediaActivityController {

    @Autowired
    private MediaActivityService mediaActivityService;

    @Autowired
    private MarathonInfoService marathonInfoService;

    @RequestMapping("/init")
    public String init() {
        return "activity/mediaactivity";
    }

    @RequestMapping("/queryByMarathon")
    @ResponseBody
    public Page<MarathonMediaActivity> queryByMarathon(@RequestBody MediaActivityQO page, HttpServletRequest request) {
        String marathonId = page.getMarathonUuid();
        String activityType = page.getActivityType();
        mediaActivityService.queryActivityByMarathon(marathonId, activityType, page);
        return page;
    }

    @RequestMapping("activitylist")
    public String activitylist(@RequestParam("marathonUuid") String marathonUuid, Model model, HttpServletRequest request) {
        MarathonInfo marathonInfo = marathonInfoService.queryById(marathonUuid);
        model.addAttribute("marathonUuid", marathonInfo.getMarathonUuid());
        model.addAttribute("marathonName", marathonInfo.getMarathonName());
        return "activity/mediaactivitylist";
    }
}
