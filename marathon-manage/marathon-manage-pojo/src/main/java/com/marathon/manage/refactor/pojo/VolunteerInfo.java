package com.marathon.manage.refactor.pojo;

import java.util.Date;

public class VolunteerInfo {
    private String id;

    private String marathonId;

    private Integer groupId;

    //分组名称
    private String groupName;

    private Integer locationId;

    //位置名称
    private String locationName;

    private Integer genderRequire;

    private Integer total;

    private String jobRequire;

    private String volunteerRequire;

    private Date trainDate;

    private Date serviceStarttime;

    private Date serviceEndtime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getMarathonId() {
        return marathonId;
    }

    public void setMarathonId(String marathonId) {
        this.marathonId = marathonId == null ? null : marathonId.trim();
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public Integer getGenderRequire() {
        return genderRequire;
    }

    public void setGenderRequire(Integer genderRequire) {
        this.genderRequire = genderRequire;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getJobRequire() {
        return jobRequire;
    }

    public void setJobRequire(String jobRequire) {
        this.jobRequire = jobRequire == null ? null : jobRequire.trim();
    }

    public String getVolunteerRequire() {
        return volunteerRequire;
    }

    public void setVolunteerRequire(String volunteerRequire) {
        this.volunteerRequire = volunteerRequire == null ? null : volunteerRequire.trim();
    }

    public Date getTrainDate() {
        return trainDate;
    }

    public void setTrainDate(Date trainDate) {
        this.trainDate = trainDate;
    }

    public Date getServiceStarttime() {
        return serviceStarttime;
    }

    public void setServiceStarttime(Date serviceStarttime) {
        this.serviceStarttime = serviceStarttime;
    }

    public Date getServiceEndtime() {
        return serviceEndtime;
    }

    public void setServiceEndtime(Date serviceEndtime) {
        this.serviceEndtime = serviceEndtime;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}