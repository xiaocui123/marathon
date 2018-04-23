package com.marathon.manage.pojo;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;
import com.marathon.manage.pojo.MarathonInfo;
import com.marathon.manage.utils.DateUtils;

import java.util.List;

/**
 * Created by cui on 2018/4/19.
 */
public class MarathonExtendInfo extends MarathonInfo {

    private List<String> lstMarathonClassify;

    private String marathonStarttimeStr;

    private String marathonEndtimeStr;

    private String marathonCreatetimeStr;

    public List<String> getLstMarathonClassify() {
        if (lstMarathonClassify == null) {
            lstMarathonClassify = Lists.newArrayList();
        }
        return lstMarathonClassify;
    }

    public void setLstMarathonClassify(List<String> lstMarathonClassify) {
        this.lstMarathonClassify = lstMarathonClassify;
    }


    public String getMarathonStarttimeStr() {
        this.marathonStarttimeStr = DateUtils.convert(super.getMarathonStarttime());
        return marathonStarttimeStr;
    }

    public void setMarathonStarttimeStr(String marathonStarttimeStr) {
        this.marathonStarttimeStr = marathonStarttimeStr;
        super.setMarathonStarttime(DateUtils.convert(marathonStarttimeStr));

    }

    public String getMarathonEndtimeStr() {
        this.marathonEndtimeStr = DateUtils.convert(getMarathonEndtime());
        return marathonEndtimeStr;
    }

    public void setMarathonEndtimeStr(String marathonEndtimeStr) {
        this.marathonEndtimeStr = marathonEndtimeStr;
        setMarathonEndtime(DateUtils.convert(marathonEndtimeStr));
    }

    public String getMarathonCreatetimeStr() {
        marathonCreatetimeStr = DateUtils.convert(getMarathonCreatetime());
        return marathonCreatetimeStr;
    }

    public void setMarathonCreatetimeStr(String marathonCreatetimeStr) {
        this.marathonCreatetimeStr = marathonCreatetimeStr;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("marathonName", getMarathonName()).toString();
    }
}
