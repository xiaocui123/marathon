package com.marathon.manage.refactor.mapper;

import com.marathon.manage.refactor.pojo.RunnerInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TimingResultMapper {

    int dropTable(@Param("tableName") String tableName);

    int existTable(String tableName);

    void createTimingResult(@Param("tableName") String tableName, @Param("cloums") List<String> cloums);


    void saveResult(@Param("tableName") String tableName, @Param("params") Map<String, String> params);

    List<Map<String, Object>> selectTimingResult(@Param("tableName") String tableName, @Param("runnerInfo") RunnerInfo runnerInfo);

}
