package com.marathon.manage.refactor.mapper;

import com.marathon.manage.refactor.pojo.RunnerInfo;
import com.marathon.manage.refactor.pojo.RunnerInfoExample;

import java.util.List;

public interface RunnerInfoMapper {
    int insert(RunnerInfo record);

    int insertSelective(RunnerInfo record);

    List<RunnerInfo> selectByExample(RunnerInfoExample example);
}