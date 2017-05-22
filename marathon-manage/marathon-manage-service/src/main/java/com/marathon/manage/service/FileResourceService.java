package com.marathon.manage.service;

import com.marathon.manage.pojo.ActivityFileResource;

import java.util.List;

/**
 * Created by cui on 2017/5/19.
 */
public interface FileResourceService {

    int addFileResource(ActivityFileResource fileResource);

    int update(ActivityFileResource fileResource);

    List<ActivityFileResource> queryByActivity(String activityId);

    int delete(String fileResourceId);

    /**
     * 删除活动相关的附件信息
     * @param activityId
     * @return
     */
    int deleteByActivity(String activityId);
}
