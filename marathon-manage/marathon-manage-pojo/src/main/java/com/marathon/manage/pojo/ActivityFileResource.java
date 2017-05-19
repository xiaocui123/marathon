package com.marathon.manage.pojo;

import java.util.Date;

public class ActivityFileResource {
    private String fileResourceId;

    private String fileResourceType;

    private String fileResourceUrl;

    private Integer activityId;

    private Date fileResourceDate;

    private String fileResourceName;

    public String getFileResourceId() {
        return fileResourceId;
    }

    public void setFileResourceId(String fileResourceId) {
        this.fileResourceId = fileResourceId == null ? null : fileResourceId.trim();
    }

    public String getFileResourceType() {
        return fileResourceType;
    }

    public void setFileResourceType(String fileResourceType) {
        this.fileResourceType = fileResourceType == null ? null : fileResourceType.trim();
    }

    public String getFileResourceUrl() {
        return fileResourceUrl;
    }

    public void setFileResourceUrl(String fileResourceUrl) {
        this.fileResourceUrl = fileResourceUrl == null ? null : fileResourceUrl.trim();
    }

    public Integer getActivityId() {
        return activityId;
    }

    public void setActivityId(Integer activityId) {
        this.activityId = activityId;
    }

    public Date getFileResourceDate() {
        return fileResourceDate;
    }

    public void setFileResourceDate(Date fileResourceDate) {
        this.fileResourceDate = fileResourceDate;
    }

    public String getFileResourceName() {
        return fileResourceName;
    }

    public void setFileResourceName(String fileResourceName) {
        this.fileResourceName = fileResourceName == null ? null : fileResourceName.trim();
    }
}