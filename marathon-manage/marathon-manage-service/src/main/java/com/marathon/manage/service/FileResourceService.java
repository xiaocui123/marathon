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
}
