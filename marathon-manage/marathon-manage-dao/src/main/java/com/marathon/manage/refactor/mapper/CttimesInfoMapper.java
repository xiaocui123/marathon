package com.marathon.manage.refactor.mapper;

import com.marathon.manage.refactor.pojo.CttimesInfo;
import com.marathon.manage.refactor.pojo.CttimesInfoExample;

import java.util.List;

public interface CttimesInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CttimesInfo record);

    int insertSelective(CttimesInfo record);

    List<CttimesInfo> selectByExample(CttimesInfoExample example);

    CttimesInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CttimesInfo record);

    int updateByPrimaryKey(CttimesInfo record);
}