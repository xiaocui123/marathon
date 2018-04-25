package com.marathon.manage.refactor.pojo;

import com.marathon.manage.utils.DateUtils;

import java.util.Date;

public class MarathonActivityInfo {
    private String activityUuid;

    private String marathonUuid;

    private String activityClassify;

    private String activityName;

    private String activityProfile;

    private Date activityPlanStarttime;
    private String activityPlanStarttimeStr;

    private Date activityPlanEndtime;
    private String activityPlanEndtimeStr;

    private String activityDirector;

    private Long activityCost;

    private String activityStatus;

    private String activityProgress;

    private Date activityRealStarttime;
    private String activityRealStarttimeStr;

    private Date activityRealEndtime;
    private String activityRealEndtimeStr;

    private Long activityRealCost;

    private String activityComments;

    private String activityCreator;

    private Date activityCreatetime;

    private String activityUpdater;

    private Date activityUpdatetime;

    private Byte activityDeleted;

    public String getActivityUuid() {
        return activityUuid;
    }

    public void setActivityUuid(String activityUuid) {
        this.activityUuid = activityUuid == null ? null : activityUuid.trim();
    }

    public String getMarathonUuid() {
        return marathonUuid;
    }

    public void setMarathonUuid(String marathonUuid) {
        this.marathonUuid = marathonUuid == null ? null : marathonUuid.trim();
    }

    public String getActivityClassify() {
        return activityClassify;
    }

    public void setActivityClassify(String activityClassify) {
        this.activityClassify = activityClassify == null ? null : activityClassify.trim();
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public String getActivityProfile() {
        return activityProfile;
    }

    public void setActivityProfile(String activityProfile) {
        this.activityProfile = activityProfile == null ? null : activityProfile.trim();
    }

    public Date getActivityPlanStarttime() {
        return activityPlanStarttime;
    }

    public void setActivityPlanStarttime(Date activityPlanStarttime) {
        this.activityPlanStarttime = activityPlanStarttime;
        this.activityPlanStarttimeStr = DateUtils.convert(activityPlanStarttime);
    }

    public Date getActivityPlanEndtime() {
        return activityPlanEndtime;
    }

    public void setActivityPlanEndtime(Date activityPlanEndtime) {

        this.activityPlanEndtime = activityPlanEndtime;
        this.activityPlanEndtimeStr = DateUtils.convert(activityPlanEndtime);
    }

    public String getActivityDirector() {
        return activityDirector;
    }

    public void setActivityDirector(String activityDirector) {
        this.activityDirector = activityDirector == null ? null : activityDirector.trim();
    }

    public Long getActivityCost() {
        return activityCost;
    }

    public void setActivityCost(Long activityCost) {
        this.activityCost = activityCost;
    }

    public String getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(String activityStatus) {
        this.activityStatus = activityStatus == null ? null : activityStatus.trim();
    }

    public String getActivityProgress() {
        return activityProgress;
    }

    public void setActivityProgress(String activityProgress) {
        this.activityProgress = activityProgress == null ? null : activityProgress.trim();
    }

    public Date getActivityRealStarttime() {
        return activityRealStarttime;
    }

    public void setActivityRealStarttime(Date activityRealStarttime) {
        this.activityRealStarttime = activityRealStarttime;
        this.activityRealStarttimeStr = DateUtils.convert(activityRealStarttime);
    }

    public Date getActivityRealEndtime() {
        return activityRealEndtime;
    }

    public void setActivityRealEndtime(Date activityRealEndtime) {
        this.activityRealEndtime = activityRealEndtime;
        this.activityRealEndtimeStr = DateUtils.convert(activityRealEndtime);
    }

    public Long getActivityRealCost() {
        return activityRealCost;
    }

    public void setActivityRealCost(Long activityRealCost) {
        this.activityRealCost = activityRealCost;
    }

    public String getActivityComments() {
        return activityComments;
    }

    public void setActivityComments(String activityComments) {
        this.activityComments = activityComments == null ? null : activityComments.trim();
    }

    public String getActivityCreator() {
        return activityCreator;
    }

    public void setActivityCreator(String activityCreator) {
        this.activityCreator = activityCreator == null ? null : activityCreator.trim();
    }

    public Date getActivityCreatetime() {
        return activityCreatetime;
    }

    public void setActivityCreatetime(Date activityCreatetime) {
        this.activityCreatetime = activityCreatetime;
    }

    public String getActivityUpdater() {
        return activityUpdater;
    }

    public void setActivityUpdater(String activityUpdater) {
        this.activityUpdater = activityUpdater == null ? null : activityUpdater.trim();
    }

    public Date getActivityUpdatetime() {
        return activityUpdatetime;
    }

    public void setActivityUpdatetime(Date activityUpdatetime) {
        this.activityUpdatetime = activityUpdatetime;
    }

    public Byte getActivityDeleted() {
        return activityDeleted;
    }

    public void setActivityDeleted(Byte activityDeleted) {
        this.activityDeleted = activityDeleted;
    }

    public String getActivityPlanStarttimeStr() {
        return activityPlanStarttimeStr;
    }

    public void setActivityPlanStarttimeStr(String activityPlanStarttimeStr) {
        this.activityPlanStarttimeStr = activityPlanStarttimeStr;
        this.activityPlanStarttime = DateUtils.convert(activityPlanStarttimeStr);
    }

    public String getActivityPlanEndtimeStr() {
        return activityPlanEndtimeStr;
    }

    public void setActivityPlanEndtimeStr(String activityPlanEndtimeStr) {
        this.activityPlanEndtimeStr = activityPlanEndtimeStr;
        this.activityPlanEndtime = DateUtils.convert(activityPlanEndtimeStr);
    }

    public String getActivityRealStarttimeStr() {
        return activityRealStarttimeStr;
    }

    public void setActivityRealStarttimeStr(String activityRealStarttimeStr) {
        this.activityRealStarttimeStr = activityRealStarttimeStr;
        this.activityRealStarttime = DateUtils.convert(activityRealStarttimeStr);
    }

    public String getActivityRealEndtimeStr() {
        return activityRealEndtimeStr;
    }

    public void setActivityRealEndtimeStr(String activityRealEndtimeStr) {
        this.activityRealEndtimeStr = activityRealEndtimeStr;
        this.activityRealEndtime = DateUtils.convert(activityRealEndtimeStr);
    }
}