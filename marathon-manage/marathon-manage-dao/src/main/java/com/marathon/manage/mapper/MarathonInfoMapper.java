package com.marathon.manage.mapper;

import com.marathon.manage.pojo.MarathonInfo;

import java.util.List;

public interface MarathonInfoMapper {
    int deleteByPrimaryKey(String marathonUuid);

    int insert(MarathonInfo record);

    int insertSelective(MarathonInfo record);

    MarathonInfo selectByPrimaryKey(String marathonUuid);

    int updateByPrimaryKeySelective(MarathonInfo record);

    int updateByPrimaryKey(MarathonInfo record);

    /**
     * 获取所有的赛事信息列表
     * @return
     */
    List<MarathonInfo> queryAllMarathons();
}