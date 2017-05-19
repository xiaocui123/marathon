package com.marathon.manage.service;

import com.marathon.manage.pojo.MarathonInfo;
import com.marathon.manage.vo.Page;

import java.util.List;

/**
 * Created by cui on 2017/5/16.
 */
public interface MarathonInfoService {

    /**
     * 添加赛事信息
     *
     * @param marathonInfo
     * @return
     */
    int addMarathon(MarathonInfo marathonInfo);

    /**
     * 获取所有的赛事信息
     *
     * @return
     * @param page
     */
    List<MarathonInfo> queryForAll(Page<MarathonInfo> page);

    MarathonInfo queryById(String marathonUuid);
}
