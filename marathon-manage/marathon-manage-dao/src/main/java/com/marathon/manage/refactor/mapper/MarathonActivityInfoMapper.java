package com.marathon.manage.refactor.mapper;

import com.marathon.manage.refactor.pojo.MarathonActivityInfo;
import com.marathon.manage.refactor.pojo.MarathonActivityInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MarathonActivityInfoMapper {
    int deleteByPrimaryKey(String activityUuid);

    int insert(MarathonActivityInfo record);

    int insertSelective(MarathonActivityInfo record);

    List<MarathonActivityInfo> selectByExample(MarathonActivityInfoExample example);

    MarathonActivityInfo selectByPrimaryKey(String activityUuid);

    int updateByExampleSelective(@Param("record") MarathonActivityInfo record, @Param("example") MarathonActivityInfoExample example);

    int updateByExample(@Param("record") MarathonActivityInfo record, @Param("example") MarathonActivityInfoExample example);

    int updateByPrimaryKeySelective(MarathonActivityInfo record);

    int updateByPrimaryKey(MarathonActivityInfo record);

    void deleteByMarathonId(String marathonUuid);
}