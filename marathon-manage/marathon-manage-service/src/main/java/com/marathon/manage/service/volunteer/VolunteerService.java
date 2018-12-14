package com.marathon.manage.service.volunteer;

import com.marathon.manage.refactor.pojo.VolunteerInfo;

import java.util.List;

/**
 * Created by cui on 2018/5/22.
 */
public interface VolunteerService {

    public List<VolunteerInfo> queryForVolunteers(String marathonId);

    public void deleteVolunteers(String marathonId);

    /**
     * 初始化赛事志愿者信息
     * @param marathonId
     */
    public void initVolunteers(String marathonId);

}
