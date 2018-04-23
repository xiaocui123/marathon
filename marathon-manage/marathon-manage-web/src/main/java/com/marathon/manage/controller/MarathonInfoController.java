package com.marathon.manage.controller;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.marathon.manage.MarathonConstants;
import com.marathon.manage.pojo.ClassifyActivitysInfo;
import com.marathon.manage.pojo.MarathonInfo;
import com.marathon.manage.pojo.MarathonExtendInfo;
import com.marathon.manage.qvo.MarathonActivityVO;
import com.marathon.manage.qvo.QueryActivityQO;
import com.marathon.manage.refactor.mapper.MarathonActivityClassifyMapper;
import com.marathon.manage.refactor.pojo.MarathonActivityClassify;
import com.marathon.manage.refactor.pojo.MarathonActivityClassifyExample;
import com.marathon.manage.refactor.pojo.MarathonActivityInfo;
import com.marathon.manage.service.MarathonInfoService;
import com.marathon.manage.utils.DateUtils;
import com.marathon.manage.vo.BaseResultBean;
import com.marathon.manage.vo.Page;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by cui on 2017/5/16.
 */
@Controller
@RequestMapping("marathon")
public class MarathonInfoController {

    @Autowired
    private MarathonInfoService marathonInfoService;

    @Autowired
    private MarathonActivityClassifyMapper classifyMapper;

    @RequestMapping("init")
    public String init() {
        return "marathon/marathonInfo";
    }

    @RequestMapping("/add")
    @ResponseBody
    public BaseResultBean addMarathon(@RequestBody MarathonExtendInfo marathonInfo, HttpServletRequest request) {
        BaseResultBean result = new BaseResultBean();
        String userId = (String) request.getSession().getAttribute(MarathonConstants.SYSTEM_USER_ID);
        marathonInfo.setMarathonCreater(userId);
        marathonInfoService.addMarathon(marathonInfo, marathonInfo.getLstMarathonClassify());
        return result;
    }

    @RequestMapping("update")
    @ResponseBody
    public BaseResultBean updateMarathon(@RequestBody MarathonExtendInfo marathonExtendInfo, HttpServletRequest request) {
        BaseResultBean resultBean = new BaseResultBean();
        Preconditions.checkArgument(!Strings.isNullOrEmpty(marathonExtendInfo.getMarathonUuid()));
        String userId = (String) request.getSession().getAttribute(MarathonConstants.SYSTEM_USER_ID);
        marathonExtendInfo.setMarathonUpdater(userId);
        marathonInfoService.updateMarathon(marathonExtendInfo);
        return resultBean;
    }

    @RequestMapping("query")
    @ResponseBody
    public Page<MarathonExtendInfo> query(@RequestBody Page<MarathonInfo> page) {
        marathonInfoService.queryForAll(page);

        Page<MarathonExtendInfo> pageExtend = new Page<>();
        BeanUtils.copyProperties(page, pageExtend, "rows");
        System.out.println(pageExtend);

        List<MarathonInfo> lstMarathonInfo = page.getRows();
        List<MarathonExtendInfo> lstMarathonExtend = Lists.transform(lstMarathonInfo, new Function<MarathonInfo, MarathonExtendInfo>() {
            @Override
            public MarathonExtendInfo apply(MarathonInfo marathonInfo) {
                MarathonExtendInfo marathonExtendInfo = new MarathonExtendInfo();
                BeanUtils.copyProperties(marathonInfo, marathonExtendInfo);
                marathonExtendInfo.getMarathonEndtimeStr();
                marathonExtendInfo.getMarathonCreatetimeStr();
                marathonExtendInfo.getMarathonEndtimeStr();
                return marathonExtendInfo;
            }
        });
        pageExtend.setRows(lstMarathonExtend);
        return pageExtend;
    }

    @RequestMapping("delete")
    @ResponseBody
    public BaseResultBean deleteMarathon(@RequestBody List<String> lstMarathonId) {
        BaseResultBean resultBean = new BaseResultBean();
        marathonInfoService.deleteMarathon(lstMarathonId);
        return resultBean;
    }

    /**
     * 查询赛事所有业务类别
     *
     * @param marathonId
     * @return
     */
    @RequestMapping(value = "activityclassify/{marathonId}", method = RequestMethod.GET)
    @ResponseBody
    public List<String> getMarathonClassfiy(@PathVariable("marathonId") final String marathonId) {
        MarathonActivityClassifyExample example = new MarathonActivityClassifyExample();
        example.or().andMarathonIdEqualTo(marathonId);
        List<MarathonActivityClassify> lstClassify = classifyMapper.selectByExample(example);
        List<String> result = Lists.transform(lstClassify, new Function<MarathonActivityClassify, String>() {
            @Override
            public String apply(MarathonActivityClassify marathonActivityClassify) {
                return marathonActivityClassify.getActivityclassify();
            }
        });
        return result;
    }
}
