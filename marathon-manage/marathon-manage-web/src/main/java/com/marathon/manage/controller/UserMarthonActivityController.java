package com.marathon.manage.controller;

import com.marathon.manage.mapper.MarathonInfoMapper;
import com.marathon.manage.pojo.MarathonInfo;
import com.marathon.manage.vo.BaseResultBean;
import com.marathon.manage.vo.SimpleResultBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 活动执行者
 * Created by cui on 2018/4/23.
 */
@Controller
@RequestMapping("userMarathonActivity")
public class UserMarthonActivityController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MarathonInfoMapper marathonInfoMapper;

    @RequestMapping("init")
    public ModelAndView init(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("activity/usermarathonactivitylist");
        return modelAndView;
    }

    /**
     * 查询所有赛事项目
     * @param request
     * @return
     */
    @RequestMapping("queryAllMarthon")
    @ResponseBody
    public BaseResultBean queryAllMarathon(HttpServletRequest request) {
        SimpleResultBean<List<MarathonInfo>> result = new SimpleResultBean<>();
        List<MarathonInfo> lstMarathon = marathonInfoMapper.queryAllMarathons();
        result.setObject(lstMarathon);
        return result;
    }
}
