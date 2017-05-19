package com.marathon.manage.service;

import com.marathon.manage.pojo.MarathonMediaActivity;
import com.marathon.manage.vo.Page;

import java.util.List;

/**
 * Created by cui on 2017/5/17.
 */
public interface MediaActivityService {

    int addActivity(MarathonMediaActivity activity);

    /**
     * 查询赛事的媒体活动
     *
     * @param marathonId:赛事ID
     * @param activityType：媒体活动类型
     * @param page：分页信息
     * @return
     */
    List<MarathonMediaActivity> queryActivityByMarathon(String marathonId, String activityType, Page<MarathonMediaActivity> page);
}
