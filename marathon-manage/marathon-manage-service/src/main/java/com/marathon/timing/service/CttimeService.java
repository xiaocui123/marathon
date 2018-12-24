package com.marathon.timing.service;

import com.marathon.manage.refactor.pojo.PointsFLow;
import com.marathon.manage.refactor.pojo.RaceGunInfo;
import com.marathon.manage.refactor.pojo.RunnerInfo;

import java.util.List;
import java.util.Map;

/**
 * @author cui
 * @version CttimeService, v0.1 2018/12/12 9:42
 */
public interface CttimeService {

    /**
     * 初步计算跑者通过Location的实际时间
     * @param runnerInfo
     * @param pointsFLows
     * @param raceGunInfo
     * @return
     */
    Map<String, Object> calcRunnerRealTimePassLocation(RunnerInfo runnerInfo, List<PointsFLow> pointsFLows, RaceGunInfo raceGunInfo);

    /**
     * 计时设置Location流程
     *
     * @return
     */
    List<PointsFLow> getPointFlow();

    /**
     * 将计算结果保存到Excel中
     */
    void saveResult2Excel();

    /**
     * 计算计时结果
     */
    Map<String,Object> calcResult(RunnerInfo runner);

    List<Map<String,Object>> queryResult(String tableName);

    /**
     * 获取动态列名称
     * @return
     */
    List<String> getColumns();

}

