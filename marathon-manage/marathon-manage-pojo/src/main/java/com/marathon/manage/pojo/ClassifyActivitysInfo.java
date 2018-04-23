package com.marathon.manage.pojo;

import com.google.common.collect.Lists;
import com.marathon.manage.refactor.pojo.MarathonActivityInfo;

import java.util.List;

/**
 * 业务活动封装类
 * Created by cui on 2018/4/22.
 */
public class ClassifyActivitysInfo {
    //赛事ID
    private String marathonId;
    //业务分类ID
    private String classifyId;

    //业务分类名称
    private String classifyName;

    //业务活动列表
    private List<MarathonActivityInfo> lstActivity;

    public String getMarathonId() {
        return marathonId;
    }

    public void setMarathonId(String marathonId) {
        this.marathonId = marathonId;
    }

    public String getClassifyId() {
        return classifyId;
    }

    public void setClassifyId(String classifyId) {
        this.classifyId = classifyId;
    }

    public String getClassifyName() {
        return classifyName;
    }

    public void setClassifyName(String classifyName) {
        this.classifyName = classifyName;
    }

    public List<MarathonActivityInfo> getLstActivity() {
        if (lstActivity == null) {
            lstActivity = Lists.newArrayList();
        }
        return lstActivity;
    }

    public void setLstActivity(List<MarathonActivityInfo> lstActivity) {
        this.lstActivity = lstActivity;
    }
}
