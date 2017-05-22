package com.marathon.manage.mapper;

import com.marathon.manage.pojo.ActivityFileResource;
import org.omg.PortableInterceptor.ACTIVE;

import java.util.List;

public interface ActivityFileResourceMapper {
    int deleteByPrimaryKey(String fileResourceId);

    int insert(ActivityFileResource record);

    int insertSelective(ActivityFileResource record);

    ActivityFileResource selectByPrimaryKey(String fileResourceId);

    int updateByPrimaryKeySelective(ActivityFileResource record);

    int updateByPrimaryKey(ActivityFileResource record);

    /**
     * 查询活动的所有附件信息
     * @param activityId
     * @return
     */
    List<ActivityFileResource> queryFilesByActivity(String activityId);
}