package com.marathon.manage.controller;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.marathon.manage.MarathonConstants;
import com.marathon.manage.pojo.ClassifyActivitysInfo;
import com.marathon.manage.pojo.MarathonInfo;
import com.marathon.manage.qvo.MarathonActivityVO;
import com.marathon.manage.qvo.QueryActivityQO;
import com.marathon.manage.refactor.mapper.MarathonActivityInfoMapper;
import com.marathon.manage.refactor.pojo.MarathonActivityInfo;
import com.marathon.manage.service.MarathonInfoService;
import com.marathon.manage.utils.DateUtils;
import com.marathon.manage.vo.BaseResultBean;
import com.marathon.manage.vo.ResultEnum;
import com.marathon.manage.vo.SimpleResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by cui on 2018/4/23.
 */
@Controller
@RequestMapping("marathonActivity")
public class MarathonActivityController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MarathonInfoService marathonInfoService;

    @Autowired
    private MarathonActivityInfoMapper activityInfoMapper;

    @RequestMapping("activitylist/init/{marathonId}")
    public ModelAndView initActivitylist(@PathVariable("marathonId") String marathonId) {
        ModelAndView modelAndView = new ModelAndView("activity/marathonactivitylist");
        MarathonInfo marathonInfo = marathonInfoService.queryById(marathonId);
        modelAndView.addObject("marathonUuid", marathonInfo.getMarathonUuid());
        modelAndView.addObject("marathonName", marathonInfo.getMarathonName());
        return modelAndView;
    }

    @RequestMapping("queryActivites")
    @ResponseBody
    public Map<String, Object> queryActivites(QueryActivityQO qo, HttpServletRequest request) {
        Map<String, Object> mapResult = Maps.newConcurrentMap();

        Map<String,Object> mapParam=qo.toMap();
        if(qo.isUser()){
            String userId = (String) request.getSession().getAttribute(MarathonConstants.SYSTEM_USER_ID);
            mapParam.put("userId",userId);
        }

        Map<String, Object> queryResult = marathonInfoService.queryClassifyActivities(mapParam);

        mapResult.put("total", queryResult.get("total"));

        List<MarathonActivityVO> lstActivityTree = Lists.newArrayList();

        List<ClassifyActivitysInfo> lstActivity = (List<ClassifyActivitysInfo>) queryResult.get("rows");

        for (ClassifyActivitysInfo classifyActivitysInfo : lstActivity) {
            MarathonActivityVO vo = new MarathonActivityVO();
            vo.setLeaf(false);
            vo.setId(classifyActivitysInfo.getClassifyId());
            vo.setName(classifyActivitysInfo.getClassifyName());

            if (classifyActivitysInfo.getLstActivity().size() > 0) {
                for (MarathonActivityInfo activityInfo : classifyActivitysInfo.getLstActivity()) {
                    MarathonActivityVO child = new MarathonActivityVO();
                    child.setId(activityInfo.getActivityUuid());
                    child.setName(activityInfo.getActivityName());
                    child.setActivityDirector(activityInfo.getActivityDirector());
                    child.setActivityPlanStarttime(DateUtils.convert(activityInfo.getActivityPlanStarttime()));
                    child.setActivityPlanEndtime(DateUtils.convert(activityInfo.getActivityPlanEndtime()));
                    child.setActivityStatus(activityInfo.getActivityStatus());
                    child.setLeaf(true);
                    vo.getChildren().add(child);
                }
            }
            lstActivityTree.add(vo);
        }
        mapResult.put("rows", lstActivityTree);
        return mapResult;
    }

    @RequestMapping("add")
    @ResponseBody
    public BaseResultBean addActivity(HttpServletRequest request, @RequestBody MarathonActivityInfo activityInfo) {
        BaseResultBean resultBean = new BaseResultBean();

        String userId = (String) request.getSession().getAttribute(MarathonConstants.SYSTEM_USER_ID);
        activityInfo.setActivityCreator(userId);
        activityInfo.setActivityStatus("0");

        activityInfo.setActivityUuid(UUID.randomUUID().toString());
        try {
            activityInfoMapper.insertSelective(activityInfo);
        } catch (Exception e) {
            logger.error("添加活动出错！", e);
            resultBean.setEnum(ResultEnum.ERROR);
        }

        return resultBean;
    }

    @RequestMapping("update")
    @ResponseBody
    public BaseResultBean updateActiviy(HttpServletRequest request, @RequestBody MarathonActivityInfo activityInfo) {
        BaseResultBean resultBean = new BaseResultBean();

        String userId = (String) request.getSession().getAttribute(MarathonConstants.SYSTEM_USER_ID);
        activityInfo.setActivityUpdater(userId);
        activityInfo.setActivityUpdatetime(new Date());

        activityInfoMapper.updateByPrimaryKeySelective(activityInfo);

        return resultBean;
    }

    @RequestMapping(value = "delete/{activityId}", method = RequestMethod.GET)
    @ResponseBody
    public BaseResultBean deleteActivity(HttpServletRequest request, @PathVariable("activityId") String activityId) {

        BaseResultBean resultBean = new BaseResultBean();

        try {
            activityInfoMapper.deleteByPrimaryKey(activityId);
        } catch (Exception e) {
            logger.error("删除活动出错！", e);
            resultBean.setEnum(ResultEnum.ERROR);
        }
        return resultBean;
    }

    /**
     * 查看活动详情
     *
     * @param activityId
     * @param request
     * @return
     */
    @RequestMapping("query/{activityId}")
    @ResponseBody
    public BaseResultBean queryActivity(@PathVariable("activiyId") String activityId, HttpServletRequest request) {
        SimpleResultBean<MarathonActivityInfo> result = new SimpleResultBean<>();

        MarathonActivityInfo activityInfo = activityInfoMapper.selectByPrimaryKey(activityId);

        result.setObject(activityInfo);

        return result;
    }
}
