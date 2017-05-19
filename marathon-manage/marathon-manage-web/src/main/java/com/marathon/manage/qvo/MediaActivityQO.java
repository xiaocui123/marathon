package com.marathon.manage.qvo;

import com.marathon.manage.pojo.MarathonMediaActivity;
import com.marathon.manage.vo.Page;

/**
 * Created by cui on 2017/5/18.
 */
public class MediaActivityQO extends Page<MarathonMediaActivity> {
    //赛事ID
    private String marathonUuid;
    //媒体活动类型
    private String activityType;

    public String getMarathonUuid() {
        return marathonUuid;
    }

    public void setMarathonUuid(String marathonUuid) {
        this.marathonUuid = marathonUuid;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType;
    }
}
