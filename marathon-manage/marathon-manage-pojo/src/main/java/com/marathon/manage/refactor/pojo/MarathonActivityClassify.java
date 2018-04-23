package com.marathon.manage.refactor.pojo;

public class MarathonActivityClassify {
    private String marathonActivityclassifyUuid;

    private String marathonId;

    private String activityclassify;

    private Boolean deletedFlag;

    public String getMarathonActivityclassifyUuid() {
        return marathonActivityclassifyUuid;
    }

    public void setMarathonActivityclassifyUuid(String marathonActivityclassifyUuid) {
        this.marathonActivityclassifyUuid = marathonActivityclassifyUuid == null ? null : marathonActivityclassifyUuid.trim();
    }

    public String getMarathonId() {
        return marathonId;
    }

    public void setMarathonId(String marathonId) {
        this.marathonId = marathonId == null ? null : marathonId.trim();
    }

    public String getActivityclassify() {
        return activityclassify;
    }

    public void setActivityclassify(String activityclassify) {
        this.activityclassify = activityclassify == null ? null : activityclassify.trim();
    }

    public Boolean getDeletedFlag() {
        return deletedFlag;
    }

    public void setDeletedFlag(Boolean deletedFlag) {
        this.deletedFlag = deletedFlag;
    }
}