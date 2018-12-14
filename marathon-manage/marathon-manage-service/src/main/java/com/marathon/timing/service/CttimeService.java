package com.marathon.timing.service;

import com.marathon.manage.refactor.pojo.CttimesInfo;
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
    public Map<String, Object> calcRunnerRealTimePassLocation(RunnerInfo runnerInfo, List<PointsFLow> pointsFLows, RaceGunInfo raceGunInfo);

    /**
     * 计时设置Location流程
     *
     * @return
     */
    public List<PointsFLow> getPointFlow();

    /**
     * 将计算结果保存到Excel中
     */
    public void saveResult2Excel();

}

