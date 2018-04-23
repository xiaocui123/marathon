package com.marathon.manage.mapper;

import com.marathon.manage.pojo.ClassifyActivitysInfo;
import com.marathon.manage.pojo.MarathonExtendInfo;
import com.marathon.manage.pojo.MarathonInfo;
import com.marathon.manage.pojo.MarathonInfoExample;
import java.util.List;
import java.util.Map;

public interface MarathonInfoMapper {
    int deleteByPrimaryKey(String marathonUuid);

    int insert(MarathonInfo record);

    int insertSelective(MarathonInfo record);

    List<MarathonInfo> selectByExample(MarathonInfoExample example);

    MarathonInfo selectByPrimaryKey(String marathonUuid);

    int updateByPrimaryKeySelective(MarathonInfo record);

    int updateByPrimaryKey(MarathonInfo record);

    List<MarathonInfo> queryAllMarathons();

    /**
     * 查询赛事所有业务分类活动
     * @param mapParam
     * @return
     */
    List<ClassifyActivitysInfo> queryClassifyActivities(Map<String,Object> mapParam);
}