package com.marathon.manage.mapper;

import com.marathon.manage.pojo.ActivityFileResource;

public interface ActivityFileResourceMapper {
    int deleteByPrimaryKey(String fileResourceId);

    int insert(ActivityFileResource record);

    int insertSelective(ActivityFileResource record);

    ActivityFileResource selectByPrimaryKey(String fileResourceId);

    int updateByPrimaryKeySelective(ActivityFileResource record);

    int updateByPrimaryKey(ActivityFileResource record);
}