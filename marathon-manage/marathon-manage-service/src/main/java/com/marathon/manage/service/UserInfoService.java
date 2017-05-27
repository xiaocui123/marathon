package com.marathon.manage.service;

import com.marathon.manage.pojo.UserInfo;

/**
 * Created by cui on 2017/5/17.
 */
public interface UserInfoService {

    /**
     * 用户登录
     * @param userInfo
     * @return
     */
    public UserInfo checkUser(UserInfo userInfo);

    int add(UserInfo user);

    int update(UserInfo user);

    int delete(String userId);

    UserInfo queryById(String userId);
}
