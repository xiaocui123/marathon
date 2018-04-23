package com.marathon;

import com.marathon.manage.mapper.*;
import com.marathon.manage.pojo.*;
import com.marathon.manage.refactor.mapper.SysDictInfoMapper;
import com.marathon.manage.refactor.pojo.SysDictInfoExample;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.UUID;

/**
 * Created by cui on 2017/5/27.
 */
public class SysMapperTest extends AbstractSpringTest {

    @Autowired
    private SysRoleInfoMapper roleInfoMapper;

    @Autowired
    private SysMenuInfoMapper menuInfoMapper;

    @Autowired
    private SysRolePermissionMapper rolePermissionMapper;

    @Autowired
    private SysUserRoleMapper userRoleMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private SysDictInfoMapper sysDictInfoMapper;

    @Test
    public void initMenu(){
        SysMenuInfo menuInfo=new SysMenuInfo();
        menuInfo.setMenuId(UUID.randomUUID().toString());
        menuInfo.setMenuName("部门人员");
        menuInfo.setMenuUrl("department/init");
        menuInfoMapper.insertSelective(menuInfo);

        SysMenuInfo marathonMenu=new SysMenuInfo();
        marathonMenu.setMenuId(UUID.randomUUID().toString());
        marathonMenu.setMenuName("赛事管理");
        marathonMenu.setMenuUrl("marathon/init");
        menuInfoMapper.insertSelective(marathonMenu);

        SysMenuInfo mediaMenu=new SysMenuInfo();
        mediaMenu.setMenuId(UUID.randomUUID().toString());
        mediaMenu.setMenuName("媒体服务");
        mediaMenu.setMenuUrl("mediaactivity/init");
        menuInfoMapper.insertSelective(mediaMenu);
    }

    @Test
    public void initRole(){
        SysRoleInfo roleInfo=new SysRoleInfo();
        roleInfo.setRoleId(UUID.randomUUID().toString());
        roleInfo.setRoleName("系统管理");
        roleInfo.setRoleDesc("系统配置管理、部门人员维护");
        roleInfoMapper.insertSelective(roleInfo);

        SysRoleInfo highRoleInfo=new SysRoleInfo();
        highRoleInfo.setRoleId(UUID.randomUUID().toString());
        highRoleInfo.setRoleName("统筹协调");
        highRoleInfo.setRoleDesc("赛事信息维护、全局工作把控");
        roleInfoMapper.insertSelective(highRoleInfo);

        SysRoleInfo mediaRoleInfo=new SysRoleInfo();
        mediaRoleInfo.setRoleId(UUID.randomUUID().toString());
        mediaRoleInfo.setRoleName("媒体工作");
        mediaRoleInfo.setRoleDesc("媒体工作，媒体活动维护");
        roleInfoMapper.insertSelective(mediaRoleInfo);
    }

    @Test
    public void initUser(){
        UserInfo userInfo=new UserInfo();
        userInfo.setUserId(UUID.randomUUID().toString());
        userInfo.setUserAccount("marathon");
        userInfo.setUserName("领导");
        userInfo.setUserPsw("96e79218965eb72c92a549dd5a330112");
        userInfoMapper.insertSelective(userInfo);

        UserInfo mediaUser=new UserInfo();
        mediaUser.setUserId(UUID.randomUUID().toString());
        mediaUser.setUserName("媒体人");
        mediaUser.setUserAccount("media");
        mediaUser.setUserPsw("96e79218965eb72c92a549dd5a330112");
        userInfoMapper.insertSelective(mediaUser);
    }

    @Test
    public void initUserRole(){
        SysUserRoleKey userRoleKey=new SysUserRoleKey();
        userRoleKey.setUserId("71e50822-2adc-4adf-a621-f5a8671378e2");
        userRoleKey.setRoleId("759f441e-2a55-4b28-99e9-107122961976");
        userRoleMapper.insert(userRoleKey);

        SysUserRoleKey marathonRoleUser=new SysUserRoleKey();
        marathonRoleUser.setUserId("6983541c-ae08-4aea-89f3-34e0651c6455");
        marathonRoleUser.setRoleId("4175ec05-41e9-446c-ab7a-5bd72c392002");
        userRoleMapper.insert(marathonRoleUser);

        SysUserRoleKey mediaRoleUser=new SysUserRoleKey();
        mediaRoleUser.setUserId("0cf8b30f-a6ca-4fab-be4d-c17ac0ffc17e");
        mediaRoleUser.setRoleId("277b3350-b289-47c3-a0eb-138d3bd79093");
        userRoleMapper.insert(mediaRoleUser);
    }

    @Test
    public void initRolePermission(){
        SysRolePermission rolePermission=new SysRolePermission();
        rolePermission.setRpId(UUID.randomUUID().toString());
        rolePermission.setRoleId("759f441e-2a55-4b28-99e9-107122961976");
        rolePermission.setPermissionId("3624fe80-b49c-490d-8956-69e382f815d3");
        rolePermissionMapper.insert(rolePermission);

        SysRolePermission marathonRolePermission=new SysRolePermission();
        marathonRolePermission.setRpId(UUID.randomUUID().toString());
        marathonRolePermission.setRoleId("4175ec05-41e9-446c-ab7a-5bd72c392002");
        marathonRolePermission.setPermissionId("fa9cba1c-5c08-483a-b2a6-df11713d7c4d");
        rolePermissionMapper.insert(marathonRolePermission);

        SysRolePermission mediaRolePermission=new SysRolePermission();
        mediaRolePermission.setRpId(UUID.randomUUID().toString());
        mediaRolePermission.setRoleId("277b3350-b289-47c3-a0eb-138d3bd79093");
        mediaRolePermission.setPermissionId("53fd4c51-0f32-4654-be17-3d88067f5225");
        rolePermissionMapper.insert(mediaRolePermission);
    }

    @Test
    public void testSysDict(){

        SysDictInfoExample example=new SysDictInfoExample();
        System.out.println(sysDictInfoMapper.selectByExample(example).size());
    }
}
