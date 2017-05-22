package com.marathon.manage.pojo;

import com.marathon.manage.utils.DateUtils;

import java.util.Date;

public class MarathonMediaActivity {
    private String mediaActivityUuid;

    private String marathonUuid;

    private String mediaActivityType;

    private String mediaActivityName;

    private Date mediaActivityStarttime;

    private String mediaActivityStarttimeStr;

    private Date mediaActivityEndtime;

    private String mediaActivityEndtimeStr;

    private String mediaActivityDirector;

    private String mediaActivityCost;

    private String mediaActivityStatus;

    private String mediaActivityProgress;

    private String mediaActivityCreator;

    private Date mediaActivityCreatetime;

    private String mediaActivityUpdater;

    private Date mediaActivityUpdatetime;

    private Byte mediaActivityDeleted;

    public String getMediaActivityUuid() {
        return mediaActivityUuid;
    }

    public void setMediaActivityUuid(String mediaActivityUuid) {
        this.mediaActivityUuid = mediaActivityUuid == null ? null : mediaActivityUuid.trim();
    }

    public String getMarathonUuid() {
        return marathonUuid;
    }

    public void setMarathonUuid(String marathonUuid) {
        this.marathonUuid = marathonUuid == null ? null : marathonUuid.trim();
    }

    public String getMediaActivityType() {
        return mediaActivityType;
    }

    public void setMediaActivityType(String mediaActivityType) {
        this.mediaActivityType = mediaActivityType == null ? null : mediaActivityType.trim();
    }

    public String getMediaActivityName() {
        return mediaActivityName;
    }

    public void setMediaActivityName(String mediaActivityName) {
        this.mediaActivityName = mediaActivityName == null ? null : mediaActivityName.trim();
    }

    public Date getMediaActivityStarttime() {
        return mediaActivityStarttime;
    }

    public void setMediaActivityStarttime(Date mediaActivityStarttime) {
        this.mediaActivityStarttime = mediaActivityStarttime;
    }

    public Date getMediaActivityEndtime() {
        return mediaActivityEndtime;
    }

    public void setMediaActivityEndtime(Date mediaActivityEndtime) {
        this.mediaActivityEndtime = mediaActivityEndtime;
    }

    public String getMediaActivityDirector() {
        return mediaActivityDirector;
    }

    public void setMediaActivityDirector(String mediaActivityDirector) {
        this.mediaActivityDirector = mediaActivityDirector == null ? null : mediaActivityDirector.trim();
    }

    public String getMediaActivityCost() {
        return mediaActivityCost;
    }

    public void setMediaActivityCost(String mediaActivityCost) {
        this.mediaActivityCost = mediaActivityCost == null ? null : mediaActivityCost.trim();
    }

    public String getMediaActivityStatus() {
        return mediaActivityStatus;
    }

    public void setMediaActivityStatus(String mediaActivityStatus) {
        this.mediaActivityStatus = mediaActivityStatus == null ? null : mediaActivityStatus.trim();
    }

    public String getMediaActivityProgress() {
        return mediaActivityProgress;
    }

    public void setMediaActivityProgress(String mediaActivityProgress) {
        this.mediaActivityProgress = mediaActivityProgress == null ? null : mediaActivityProgress.trim();
    }

    public String getMediaActivityCreator() {
        return mediaActivityCreator;
    }

    public void setMediaActivityCreator(String mediaActivityCreator) {
        this.mediaActivityCreator = mediaActivityCreator == null ? null : mediaActivityCreator.trim();
    }

    public Date getMediaActivityCreatetime() {
        return mediaActivityCreatetime;
    }

    public void setMediaActivityCreatetime(Date mediaActivityCreatetime) {
        this.mediaActivityCreatetime = mediaActivityCreatetime;
    }

    public String getMediaActivityUpdater() {
        return mediaActivityUpdater;
    }

    public void setMediaActivityUpdater(String mediaActivityUpdater) {
        this.mediaActivityUpdater = mediaActivityUpdater == null ? null : mediaActivityUpdater.trim();
    }

    public Date getMediaActivityUpdatetime() {
        return mediaActivityUpdatetime;
    }

    public void setMediaActivityUpdatetime(Date mediaActivityUpdatetime) {
        this.mediaActivityUpdatetime = mediaActivityUpdatetime;
    }

    public Byte getMediaActivityDeleted() {
        return mediaActivityDeleted;
    }

    public void setMediaActivityDeleted(Byte mediaActivityDeleted) {
        this.mediaActivityDeleted = mediaActivityDeleted;
    }

    public String getMediaActivityStarttimeStr() {
        this.mediaActivityStarttimeStr = DateUtils.convert(mediaActivityStarttime);
        return mediaActivityStarttimeStr;
    }

    public void setMediaActivityStarttimeStr(String mediaActivityStarttimeStr) {
        this.mediaActivityStarttimeStr = mediaActivityStarttimeStr;
        this.mediaActivityStarttime = DateUtils.convert(mediaActivityStarttimeStr);
    }

    public String getMediaActivityEndtimeStr() {
        this.mediaActivityEndtimeStr = DateUtils.convert(mediaActivityEndtime);
        return mediaActivityEndtimeStr;
    }

    public void setMediaActivityEndtimeStr(String mediaActivityEndtimeStr) {
        this.mediaActivityEndtimeStr = mediaActivityEndtimeStr;
        this.mediaActivityEndtime = DateUtils.convert(mediaActivityEndtimeStr);
    }
}