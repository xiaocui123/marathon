package com.marathon.manage.mapper;

import com.marathon.manage.pojo.MarathonMediaActivity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MarathonMediaActivityMapper {
    int deleteByPrimaryKey(String mediaActivityUuid);

    int insert(MarathonMediaActivity record);

    int insertSelective(MarathonMediaActivity record);

    MarathonMediaActivity selectByPrimaryKey(String mediaActivityUuid);

    int updateByPrimaryKeySelective(MarathonMediaActivity record);

    int updateByPrimaryKey(MarathonMediaActivity record);

    /**
     * 查询赛事的媒体活动列表
     *
     * @param marathonId
     * @param activityType
     * @return
     */
    List<MarathonMediaActivity> queryByMarathon(@Param("marathonId") String marathonId, @Param("activityType") String activityType);
}