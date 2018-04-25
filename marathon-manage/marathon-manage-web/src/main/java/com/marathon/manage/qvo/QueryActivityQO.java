package com.marathon.manage.qvo;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

/**
 * 查询赛事活动请求类
 * Created by cui on 2018/4/22.
 */
public class QueryActivityQO {
    private int page;
    private int rows;

    private String marathonId;
    //是否是执行人
    private boolean user;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getMarathonId() {
        return marathonId;
    }

    public void setMarathonId(String marathonId) {
        this.marathonId = marathonId;
    }

    public boolean isUser() {
        return user;
    }

    public void setUser(boolean user) {
        this.user = user;
    }

    public Map<String, Object> toMap() {
        ObjectMapper m = new ObjectMapper();
        return m.convertValue(this, Map.class);
    }
}
