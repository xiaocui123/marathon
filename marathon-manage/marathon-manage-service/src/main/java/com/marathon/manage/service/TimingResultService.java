package com.marathon.manage.service;

import com.marathon.manage.refactor.pojo.PointsFLow;
import com.marathon.manage.refactor.pojo.RunnerInfo;
import com.marathon.manage.vo.Page;

import java.util.List;
import java.util.Map;

/**
 * @author cui
 * @version TimingResultService, v0.1 2018/12/24 11:27
 */
public interface TimingResultService {

    /**
     * 删除表
     * @param tableName
     * @return
     */
    int dropTable(String tableName);

    /**
     * 表是否存在
     * @param tableName
     * @return
     */
    boolean existTable(String tableName);
    /**
     * 创建计时结果表
     * @param tableName
     * @param cloums
     */
    void createTimingResult(String tableName, List<String> cloums);

    /**
     * 保存计时结果
     * @param tableName
     * @param params
     */
    void saveResult(String tableName,  Map<String, String> params);

    Page<Map<String, Object>> queryForAll(RunnerInfo qo,int offset,int limit);

    List<Map<String,Object>> sortResult(List<PointsFLow> lstFlow, List<Map<String, Object>> lstResult);
}
