package com.marathon.manage.refactor.mapper;

import com.marathon.manage.refactor.pojo.RaceGunInfo;
import com.marathon.manage.refactor.pojo.RaceGunInfoExample;
import java.util.List;

public interface RaceGunInfoMapper {
    int insert(RaceGunInfo record);

    int insertSelective(RaceGunInfo record);

    List<RaceGunInfo> selectByExample(RaceGunInfoExample example);
}