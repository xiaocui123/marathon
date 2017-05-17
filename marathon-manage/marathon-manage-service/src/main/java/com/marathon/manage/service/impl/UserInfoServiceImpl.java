package com.marathon.manage.service.impl;

import com.marathon.manage.mapper.UserInfoMapper;
import com.marathon.manage.pojo.UserInfo;
import com.marathon.manage.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by cui on 2017/5/17.
 */
@Service("UserInfoService")
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo checkUser(UserInfo userInfo) {
        return userInfoMapper.checkUser(userInfo);
    }
}
