package com.marathon.manage.refactor.mapper;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TimingResultMapper {

    int dropTable(@Param("tableName") String tableName);

    int existTable(String tableName);

    void createTimingResult(@Param("tableName") String tableName, @Param("cloums") List<String> cloums);


    void saveResult(@Param("tableName") String tableName,@Param("params") Map<String, String> params);

    /**
     * @Description: 单纯返回id作为key的map
     * @MapKey("id") Map<Long   ,       Object> selectTaskResult(@Param("tableName")String tableName, @Param("startDate")Date startDate, @Param("endDate")Date endDate)
     */

    List<Map<String, Object>> selectTimingResult(@Param("tableName") String tableName);

}
