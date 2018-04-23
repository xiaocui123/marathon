package com.marathon.manage.qvo;

import com.marathon.manage.vo.BaseTreeGridVO;

/**
 * Created by cui on 2018/4/22.
 */
public class MarathonActivityVO extends BaseTreeGridVO<MarathonActivityVO> {
    //业务名称/活动名称
    private String name;

    //活动属性
    //活动计划开始时间
    private String activityPlanStarttime;

    //活动计划结束时间
    private String activityPlanEndtime;

    //活动执行者
    private String activityDirector;

    //活动状态
    private String activityStatus;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActivityPlanStarttime() {
        return activityPlanStarttime;
    }

    public void setActivityPlanStarttime(String activityPlanStarttime) {
        this.activityPlanStarttime = activityPlanStarttime;
    }

    public String getActivityPlanEndtime() {
        return activityPlanEndtime;
    }

    public void setActivityPlanEndtime(String activityPlanEndtime) {
        this.activityPlanEndtime = activityPlanEndtime;
    }

    public String getActivityDirector() {
        return activityDirector;
    }

    public void setActivityDirector(String activityDirector) {
        this.activityDirector = activityDirector;
    }

    public String getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(String activityStatus) {
        this.activityStatus = activityStatus;
    }
}
