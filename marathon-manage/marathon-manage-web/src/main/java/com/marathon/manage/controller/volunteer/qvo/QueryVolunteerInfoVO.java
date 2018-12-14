package com.marathon.manage.controller.volunteer.qvo;

import com.marathon.manage.vo.BaseTreeGridVO;

/**
 * 志愿者需求树形结构
 * Created by cui on 2018/5/22.
 */
public class QueryVolunteerInfoVO extends BaseTreeGridVO<QueryVolunteerInfoVO> {

    //分组名称
    private String groupName;

    //位置名称
    private String locationName;

    //数量
    private Integer total;

    //男/女/不限
    private String genderRequire;

    //职责要求
    private String jobRequire;

    //志愿者要求
    private String volunteerRequire;

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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getGenderRequire() {
        return genderRequire;
    }

    public void setGenderRequire(String genderRequire) {
        this.genderRequire = genderRequire;
    }

    public String getJobRequire() {
        return jobRequire;
    }

    public void setJobRequire(String jobRequire) {
        this.jobRequire = jobRequire;
    }

    public String getVolunteerRequire() {
        return volunteerRequire;
    }

    public void setVolunteerRequire(String volunteerRequire) {
        this.volunteerRequire = volunteerRequire;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof QueryVolunteerInfoVO) {
            QueryVolunteerInfoVO objExt = (QueryVolunteerInfoVO) obj;
            return this.getId().equals(objExt.getId());
        } else {
            return false;
        }

    }
}
