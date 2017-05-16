package com.marathon.manage.mapper;

import com.marathon.manage.pojo.MarathonMediaActivity;

public interface MarathonMediaActivityMapper {
    int deleteByPrimaryKey(String mediaActivityUuid);

    int insert(MarathonMediaActivity record);

    int insertSelective(MarathonMediaActivity record);

    MarathonMediaActivity selectByPrimaryKey(String mediaActivityUuid);

    int updateByPrimaryKeySelective(MarathonMediaActivity record);

    int updateByPrimaryKey(MarathonMediaActivity record);
}