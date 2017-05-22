package com.marathon.manage.controller;

import com.marathon.manage.MarathonConstants;
import com.marathon.manage.pojo.ActivityFileResource;
import com.marathon.manage.pojo.MarathonInfo;
import com.marathon.manage.pojo.MarathonMediaActivity;
import com.marathon.manage.qvo.AddMediaActivityQO;
import com.marathon.manage.qvo.MediaActivityQO;
import com.marathon.manage.service.FileResourceService;
import com.marathon.manage.service.MarathonInfoService;
import com.marathon.manage.service.MediaActivityService;
import com.marathon.manage.vo.JSONResult;
import com.marathon.manage.vo.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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

    @Autowired
    private FileResourceService fileResourceService;

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

    @RequestMapping("/add")
    @ResponseBody
    public JSONResult add(@RequestBody AddMediaActivityQO qo, HttpServletRequest request) {
        JSONResult result = new JSONResult();
        MarathonMediaActivity activity = qo;
        String activityId = UUID.randomUUID().toString();
        activity.setMediaActivityUuid(activityId);
        mediaActivityService.addActivity(activity);
        if (qo.getLstFileResourceId().size() > 0) {
            for (String fileResourceId : qo.getLstFileResourceId()) {
                ActivityFileResource fileResource = new ActivityFileResource();
                fileResource.setFileResourceId(fileResourceId);
                fileResource.setActivityId(activityId);
                fileResourceService.update(fileResource);
            }
        }
        return result;
    }

    @RequestMapping("update")
    @ResponseBody
    public JSONResult update(@RequestBody MarathonMediaActivity activity,HttpServletRequest request){
        JSONResult result=new JSONResult();
        String userId= (String) request.getSession().getAttribute(MarathonConstants.SYSTEM_USER_ID);
        activity.setMediaActivityUpdater(userId);
        activity.setMediaActivityUpdatetime(new Date());
        mediaActivityService.updateActivity(activity);
        return result;
    }

    @RequestMapping("/queryFileResources")
    @ResponseBody
    public List<ActivityFileResource> queryFileResources(@RequestParam("activityId") String activityId) {
        return fileResourceService.queryByActivity(activityId);
    }

    @RequestMapping("/delete")
    @ResponseBody
    public JSONResult delete(@RequestBody List<String> arrayActivityId){
        JSONResult result=new JSONResult();
        mediaActivityService.deleteActivity(arrayActivityId);
        return result;
    }
}
