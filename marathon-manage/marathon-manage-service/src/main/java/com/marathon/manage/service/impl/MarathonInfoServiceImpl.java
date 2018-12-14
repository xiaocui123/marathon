package com.marathon.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.google.common.collect.Maps;
import com.marathon.manage.mapper.MarathonInfoMapper;
import com.marathon.manage.pojo.ClassifyActivitysInfo;
import com.marathon.manage.pojo.MarathonExtendInfo;
import com.marathon.manage.pojo.MarathonInfo;
import com.marathon.manage.refactor.mapper.MarathonActivityClassifyMapper;
import com.marathon.manage.refactor.mapper.MarathonActivityInfoMapper;
import com.marathon.manage.refactor.pojo.ClassifyModelCustomize;
import com.marathon.manage.refactor.pojo.MarathonActivityClassify;
import com.marathon.manage.refactor.pojo.MarathonActivityClassifyExample;
import com.marathon.manage.refactor.pojo.MarathonActivityInfo;
import com.marathon.manage.service.MarathonInfoService;
import com.marathon.manage.utils.MarathonModelParser;
import com.marathon.manage.vo.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by cui on 2017/5/16.
 */
@Service("MarathonInfoService")
public class MarathonInfoServiceImpl implements MarathonInfoService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MarathonInfoMapper marathonInfoMapper;

    @Autowired
    private MarathonActivityClassifyMapper marathonActivityClassifyMapper;

    @Autowired
    private MarathonActivityInfoMapper marathonActivityInfoMapper;

    @Override
    public int addMarathon(MarathonInfo marathonInfo, List<String> lstMarathonClassify) {
        if (marathonInfo.getMarathonUuid() == null) {
            marathonInfo.setMarathonUuid(UUID.randomUUID().toString());
        }
        marathonInfoMapper.insertSelective(marathonInfo);

        initMarthonFromConfig(marathonInfo, lstMarathonClassify);
        return 0;
    }

    @Override
    public void updateMarathon(MarathonExtendInfo marathonExtendInfo) {
        marathonInfoMapper.updateByPrimaryKeySelective(marathonExtendInfo);

        marathonActivityClassifyMapper.deleteByMarathonId(marathonExtendInfo.getMarathonUuid());

        marathonActivityInfoMapper.deleteByMarathonId(marathonExtendInfo.getMarathonUuid());

        initMarthonFromConfig(marathonExtendInfo,marathonExtendInfo.getLstMarathonClassify());
    }

    /**
     * 配置文件-初始化赛事活动
     * @param marathonInfo
     * @param lstMarathonClassify
     */
    private void initMarthonFromConfig(MarathonInfo marathonInfo, List<String> lstMarathonClassify) {
        List<ClassifyModelCustomize> lstClassifyModel = MarathonModelParser.getClassifyModel();
        for (String marathonClassify : lstMarathonClassify) {

            ClassifyModelCustomize cmodel = null;
            for (ClassifyModelCustomize classifyModel : lstClassifyModel) {
                if (marathonClassify.equals(String.valueOf(classifyModel.getId()))) {
                    cmodel = classifyModel;
                    break;
                }
            }
            if (cmodel != null) {
                String classifyUUid= UUID.randomUUID().toString();

                //先排下序
                Collections.sort(cmodel.getLstActivity(), new Comparator<ClassifyModelCustomize.ActivityModelCustomize>() {
                    @Override
                    public int compare(ClassifyModelCustomize.ActivityModelCustomize o1, ClassifyModelCustomize.ActivityModelCustomize o2) {
                        return o1.getSortNo().compareTo(o2.getSortNo());
                    }
                });
                //初始化活动列表
                for(ClassifyModelCustomize.ActivityModelCustomize activityModel:cmodel.getLstActivity()){
                    MarathonActivityInfo activityInfo=new MarathonActivityInfo();
                    activityInfo.setMarathonUuid(marathonInfo.getMarathonUuid());
                    activityInfo.setActivityClassify(marathonClassify);
                    activityInfo.setActivityName(activityModel.getName());
                    activityInfo.setActivityUuid(UUID.randomUUID().toString());
                    activityInfo.setActivityStatus("0");
                    marathonActivityInfoMapper.insertSelective(activityInfo);
                }
                //初始化赛事和业务类别对应关系
                MarathonActivityClassify classify = new MarathonActivityClassify();
                classify.setMarathonActivityclassifyUuid(classifyUUid);
                classify.setMarathonId(marathonInfo.getMarathonUuid());
                classify.setActivityclassify(marathonClassify);
                marathonActivityClassifyMapper.insertSelective(classify);
            }
        }
    }

    @Override
    public void deleteMarathon(List<String> lstMarathonId) {
        for (String marathonId : lstMarathonId) {
            marathonInfoMapper.deleteByPrimaryKey(marathonId);
            marathonActivityClassifyMapper.deleteByMarathonId(marathonId);
        }
    }

    @Override
    public List<MarathonInfo> queryForAll(Page<MarathonInfo> page) {
        PageHelper.offsetPage(page.getOffset(), page.getLimit());
        List<MarathonInfo> lstMarathon = marathonInfoMapper.queryAllMarathons();
        com.github.pagehelper.Page<MarathonInfo> result = (com.github.pagehelper.Page<MarathonInfo>) lstMarathon;
        page.setTotal((int) result.getTotal());
        page.setRows(result.getResult());
        return lstMarathon;
    }

    @Override
    public MarathonInfo queryById(String marathonUuid) {
        return marathonInfoMapper.selectByPrimaryKey(marathonUuid);
    }

    @Override
    public Map<String, Object> queryClassifyActivities(Map<String, Object> mapParam) {
        Map<String, Object> result = Maps.newHashMap();
        PageHelper.startPage((int) mapParam.get("page"), (int) mapParam.get("rows"));
        List<ClassifyActivitysInfo> lstActivity = marathonInfoMapper.queryClassifyActivities(mapParam);
        result.put("rows", lstActivity);
        long total = ((com.github.pagehelper.Page) lstActivity).getTotal();
        result.put("total", total);
        return result;
    }
}
