package com.marathon.manage.refactor.mapper;

import com.marathon.manage.refactor.pojo.PointsFLow;
import com.marathon.manage.refactor.pojo.PointsFLowExample;
import java.util.List;

public interface PointsFLowMapper {
    int insert(PointsFLow record);

    int insertSelective(PointsFLow record);

    List<PointsFLow> selectByExample(PointsFLowExample example);
}