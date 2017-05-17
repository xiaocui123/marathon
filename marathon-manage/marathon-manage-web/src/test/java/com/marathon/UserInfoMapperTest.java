package com.marathon;

import com.marathon.manage.mapper.UserInfoMapper;
import com.marathon.manage.pojo.UserInfo;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * Created by cui on 2017/5/17.
 */
public class UserInfoMapperTest extends AbstractSpringTest {

    @Autowired
    private UserInfoMapper mapper;

    @Test
    public void tesTInsert(){
        UserInfo userInfo=new UserInfo();
        userInfo.setUserId(UUID.randomUUID().toString());
        userInfo.setUserAccount("admin");
        userInfo.setUserPsw("96e79218965eb72c92a549dd5a330112");
        userInfo.setUserName("管理员");
        mapper.insert(userInfo);
    }
}
