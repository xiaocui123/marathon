package com.marathon.manage.refactor.mapper;

import com.marathon.manage.refactor.pojo.VolunteerInfo;
import com.marathon.manage.refactor.pojo.VolunteerInfoExample;
import java.util.List;

public interface VolunteerInfoMapper {
    int insert(VolunteerInfo record);

    int insertSelective(VolunteerInfo record);

    List<VolunteerInfo> selectByExample(VolunteerInfoExample example);

    void deleteByMarathonId(String marathonId);
}