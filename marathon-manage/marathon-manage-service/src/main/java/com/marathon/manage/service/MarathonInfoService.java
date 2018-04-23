package com.marathon.manage.service;

import com.marathon.manage.pojo.ClassifyActivitysInfo;
import com.marathon.manage.pojo.MarathonExtendInfo;
import com.marathon.manage.pojo.MarathonInfo;
import com.marathon.manage.vo.Page;

import java.util.List;
import java.util.Map;

/**
 * Created by cui on 2017/5/16.
 */
public interface MarathonInfoService {

    /**
     * 添加赛事信息
     *
     * @param marathonInfo
     * @param lstMarathonClassify
     * @return
     */
    int addMarathon(MarathonInfo marathonInfo, List<String> lstMarathonClassify);

    /**
     * 获取所有的赛事信息
     *
     * @param page
     * @return
     */
    List<MarathonInfo> queryForAll(Page<MarathonInfo> page);

    MarathonInfo queryById(String marathonUuid);

    void updateMarathon(MarathonExtendInfo marathonExtendInfo);

    void deleteMarathon(List<String> lstMarathonId);

    /**
     * @param mapParam
     * @return
     */
    Map<String,Object> queryClassifyActivities(Map<String, Object> mapParam);
}
