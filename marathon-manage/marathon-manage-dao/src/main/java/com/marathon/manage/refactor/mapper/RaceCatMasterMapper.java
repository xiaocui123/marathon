package com.marathon.manage.refactor.mapper;

import com.marathon.manage.refactor.pojo.RaceCatMaster;
import com.marathon.manage.refactor.pojo.RaceCatMasterExample;
import java.util.List;

public interface RaceCatMasterMapper {
    int insert(RaceCatMaster record);

    int insertSelective(RaceCatMaster record);

    List<RaceCatMaster> selectByExample(RaceCatMasterExample example);
}