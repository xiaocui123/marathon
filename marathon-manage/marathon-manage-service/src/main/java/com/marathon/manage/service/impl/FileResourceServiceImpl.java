package com.marathon.manage.service.impl;

import com.marathon.manage.mapper.ActivityFileResourceMapper;
import com.marathon.manage.pojo.ActivityFileResource;
import com.marathon.manage.service.FileResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by cui on 2017/5/19.
 */
@Service("FileResourceService")
public class FileResourceServiceImpl implements FileResourceService {

    @Autowired
    private ActivityFileResourceMapper fileResourceMapper;

    @Override
    public int addFileResource(ActivityFileResource fileResource) {
        if (fileResource.getFileResourceId() == null) {
            fileResource.setFileResourceId(UUID.randomUUID().toString());
        }
        return fileResourceMapper.insertSelective(fileResource);
    }

    @Override
    public int update(ActivityFileResource fileResource) {
        return fileResourceMapper.updateByPrimaryKeySelective(fileResource);
    }

    @Override
    public List<ActivityFileResource> queryByActivity(String activityId) {
        return fileResourceMapper.queryFilesByActivity(activityId);
    }

    @Override
    public int delete(String fileResourceId) {
        return fileResourceMapper.deleteByPrimaryKey(fileResourceId);
    }

    @Override
    public int deleteByActivity(String activityId) {
        return fileResourceMapper.deleteByActivity(activityId);
    }
}
