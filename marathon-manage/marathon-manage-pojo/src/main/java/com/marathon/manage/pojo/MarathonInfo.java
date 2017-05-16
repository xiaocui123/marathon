package com.marathon.manage.pojo;

import com.google.common.base.MoreObjects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MarathonInfo {
    private String marathonUuid;

    private String marathonName;

    private Date marathonStarttime;

    private String marathonStarttimeStr;

    private Date marathonEndtime;

    private String marathonEndtimeStr;

    private String marathonAddress;

    private String marathonCreater;

    private Date marathonCreatetime;

    private String marathonUpdater;

    private Date marathonUpdatetime;

    private Byte marathonDeleted;

    public String getMarathonUuid() {
        return marathonUuid;
    }

    public void setMarathonUuid(String marathonUuid) {
        this.marathonUuid = marathonUuid == null ? null : marathonUuid.trim();
    }

    public String getMarathonName() {
        return marathonName;
    }

    public void setMarathonName(String marathonName) {
        this.marathonName = marathonName == null ? null : marathonName.trim();
    }

    public Date getMarathonStarttime() {
        return marathonStarttime;
    }

    public void setMarathonStarttime(Date marathonStarttime) {
        this.marathonStarttime = marathonStarttime;
    }

    public Date getMarathonEndtime() {
        return marathonEndtime;
    }

    public void setMarathonEndtime(Date marathonEndtime) {
        this.marathonEndtime = marathonEndtime;
    }

    public String getMarathonAddress() {
        return marathonAddress;
    }

    public void setMarathonAddress(String marathonAddress) {
        this.marathonAddress = marathonAddress == null ? null : marathonAddress.trim();
    }

    public String getMarathonCreater() {
        return marathonCreater;
    }

    public void setMarathonCreater(String marathonCreater) {
        this.marathonCreater = marathonCreater == null ? null : marathonCreater.trim();
    }

    public Date getMarathonCreatetime() {
        return marathonCreatetime;
    }

    public void setMarathonCreatetime(Date marathonCreatetime) {
        this.marathonCreatetime = marathonCreatetime;
    }

    public String getMarathonUpdater() {
        return marathonUpdater;
    }

    public void setMarathonUpdater(String marathonUpdater) {
        this.marathonUpdater = marathonUpdater == null ? null : marathonUpdater.trim();
    }

    public Date getMarathonUpdatetime() {
        return marathonUpdatetime;
    }

    public void setMarathonUpdatetime(Date marathonUpdatetime) {
        this.marathonUpdatetime = marathonUpdatetime;
    }

    public Byte getMarathonDeleted() {
        return marathonDeleted;
    }

    public void setMarathonDeleted(Byte marathonDeleted) {
        this.marathonDeleted = marathonDeleted;
    }

    public String getMarathonStarttimeStr() {
        return marathonStarttimeStr;
    }

    public void setMarathonStarttimeStr(String marathonStarttimeStr) {
        try {
            this.marathonStarttimeStr = marathonStarttimeStr;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            this.marathonStarttime = sdf.parse(marathonStarttimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public String getMarathonEndtimeStr() {
        return marathonEndtimeStr;
    }

    public void setMarathonEndtimeStr(String marathonEndtimeStr) {
        try {
            this.marathonEndtimeStr = marathonEndtimeStr;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
            this.marathonEndtime = sdf.parse(marathonEndtimeStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("marathonName", marathonName).toString();
    }
}