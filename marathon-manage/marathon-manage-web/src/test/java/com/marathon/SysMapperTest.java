package com.marathon;

import com.marathon.manage.mapper.*;
import com.marathon.manage.pojo.*;
import com.marathon.manage.refactor.mapper.SysDictInfoMapper;
import com.marathon.manage.refactor.mapper.VolunteerInfoMapper;
import com.marathon.manage.refactor.pojo.SysDictInfo;
import com.marathon.manage.refactor.pojo.SysDictInfoExample;
import com.marathon.manage.refactor.pojo.VolunteerInfo;
import com.marathon.manage.service.volunteer.VolunteerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.SimpleSecurityContextProvider;

import java.util.List;
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

    @Autowired
    private VolunteerInfoMapper volunteerInfoMapper;

    @Autowired
    private VolunteerService volunteerService;

    @Test
    public void initMenu() {
        SysMenuInfo menuInfo = new SysMenuInfo();
        menuInfo.setMenuId(UUID.randomUUID().toString());
        menuInfo.setMenuName("部门人员");
        menuInfo.setMenuUrl("department/init");
        menuInfoMapper.insertSelective(menuInfo);

        SysMenuInfo marathonMenu = new SysMenuInfo();
        marathonMenu.setMenuId(UUID.randomUUID().toString());
        marathonMenu.setMenuName("赛事管理");
        marathonMenu.setMenuUrl("marathon/init");
        menuInfoMapper.insertSelective(marathonMenu);

        SysMenuInfo mediaMenu = new SysMenuInfo();
        mediaMenu.setMenuId(UUID.randomUUID().toString());
        mediaMenu.setMenuName("媒体服务");
        mediaMenu.setMenuUrl("mediaactivity/init");
        menuInfoMapper.insertSelective(mediaMenu);
    }

    @Test
    public void initRole() {
        SysRoleInfo roleInfo = new SysRoleInfo();
        roleInfo.setRoleId(UUID.randomUUID().toString());
        roleInfo.setRoleName("系统管理");
        roleInfo.setRoleDesc("系统配置管理、部门人员维护");
        roleInfoMapper.insertSelective(roleInfo);

        SysRoleInfo highRoleInfo = new SysRoleInfo();
        highRoleInfo.setRoleId(UUID.randomUUID().toString());
        highRoleInfo.setRoleName("统筹协调");
        highRoleInfo.setRoleDesc("赛事信息维护、全局工作把控");
        roleInfoMapper.insertSelective(highRoleInfo);

        SysRoleInfo mediaRoleInfo = new SysRoleInfo();
        mediaRoleInfo.setRoleId(UUID.randomUUID().toString());
        mediaRoleInfo.setRoleName("媒体工作");
        mediaRoleInfo.setRoleDesc("媒体工作，媒体活动维护");
        roleInfoMapper.insertSelective(mediaRoleInfo);
    }

    @Test
    public void initUser() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(UUID.randomUUID().toString());
        userInfo.setUserAccount("marathon");
        userInfo.setUserName("领导");
        userInfo.setUserPsw("96e79218965eb72c92a549dd5a330112");
        userInfoMapper.insertSelective(userInfo);

        UserInfo mediaUser = new UserInfo();
        mediaUser.setUserId(UUID.randomUUID().toString());
        mediaUser.setUserName("媒体人");
        mediaUser.setUserAccount("media");
        mediaUser.setUserPsw("96e79218965eb72c92a549dd5a330112");
        userInfoMapper.insertSelective(mediaUser);
    }

    @Test
    public void initUserRole() {
        SysUserRoleKey userRoleKey = new SysUserRoleKey();
        userRoleKey.setUserId("71e50822-2adc-4adf-a621-f5a8671378e2");
        userRoleKey.setRoleId("759f441e-2a55-4b28-99e9-107122961976");
        userRoleMapper.insert(userRoleKey);

        SysUserRoleKey marathonRoleUser = new SysUserRoleKey();
        marathonRoleUser.setUserId("6983541c-ae08-4aea-89f3-34e0651c6455");
        marathonRoleUser.setRoleId("4175ec05-41e9-446c-ab7a-5bd72c392002");
        userRoleMapper.insert(marathonRoleUser);

        SysUserRoleKey mediaRoleUser = new SysUserRoleKey();
        mediaRoleUser.setUserId("0cf8b30f-a6ca-4fab-be4d-c17ac0ffc17e");
        mediaRoleUser.setRoleId("277b3350-b289-47c3-a0eb-138d3bd79093");
        userRoleMapper.insert(mediaRoleUser);
    }

    @Test
    public void initRolePermission() {
        SysRolePermission rolePermission = new SysRolePermission();
        rolePermission.setRpId(UUID.randomUUID().toString());
        rolePermission.setRoleId("759f441e-2a55-4b28-99e9-107122961976");
        rolePermission.setPermissionId("3624fe80-b49c-490d-8956-69e382f815d3");
        rolePermissionMapper.insert(rolePermission);

        SysRolePermission marathonRolePermission = new SysRolePermission();
        marathonRolePermission.setRpId(UUID.randomUUID().toString());
        marathonRolePermission.setRoleId("4175ec05-41e9-446c-ab7a-5bd72c392002");
        marathonRolePermission.setPermissionId("fa9cba1c-5c08-483a-b2a6-df11713d7c4d");
        rolePermissionMapper.insert(marathonRolePermission);

        SysRolePermission mediaRolePermission = new SysRolePermission();
        mediaRolePermission.setRpId(UUID.randomUUID().toString());
        mediaRolePermission.setRoleId("277b3350-b289-47c3-a0eb-138d3bd79093");
        mediaRolePermission.setPermissionId("53fd4c51-0f32-4654-be17-3d88067f5225");
        rolePermissionMapper.insert(mediaRolePermission);
    }

    @Test
    public void initVolunteerDict() {
        String[] areaArray = {"问讯处", "集结区", "特邀选手", "更衣区", "存包区", "起终点移动厕所指引", "起终点医疗中心", "赛会执行中心", "颁奖等候区", "VIP区", "媒体区", "终点补给区", "计时区", "冲刺区", "起跑倒计时举牌", "停车场指引",
                "沿途饮水饮料补给站", "沿途医疗站", "沿途赛道指引 手举KT板", "赛后按摩区", "彩绘区", "技术官员", "竞赛主管", "检录裁判长-配志愿者", "起终点裁判长-配志愿者", "检查裁判长", "编排记录裁判长",
                "兴奋剂检察官-配志愿者", "特约选手服务", "自备饮料", "机动组"};

        SysDictInfo sysDictInfo = new SysDictInfo();
        sysDictInfo.setId(251);
        sysDictInfo.setName("volunteer_require");
        sysDictInfo.setVal("志愿者需求");
        sysDictInfoMapper.insertSelective(sysDictInfo);

        for (int i = 1; i <= areaArray.length; i++) {
            SysDictInfo sysDictInfo1 = new SysDictInfo();
            sysDictInfo1.setId(2510 + i);
            sysDictInfo1.setParent(251);
            sysDictInfo1.setVal(areaArray[i - 1]);
            sysDictInfo1.setSortno(i);
            sysDictInfoMapper.insertSelective(sysDictInfo1);
        }

        int parentId = 2511;
        String[] wenxunche = {"地铁出口", "安检入口前", "安检入口后"};

        int parentId1 = 2512;
        String[] jijeche = {"半程组别特邀选手集结区", "半程组别大众选手集结A区", "半程组别大众选手集结B区", "迷你组别集结区"};

        int parentId2 = 2513;
        String[] tyxs = {"特邀选手接待处"};

        int parentId3 = 2514;
        String[] gyq = {"半程、迷你选手更衣区"};

        int parentId4 = 2515;
        String[] cbq = {"半程组别大众A区存包", "半程组别大众B区存包", "迷你组别存包区"};

        int parentId5 = 2522;
        String[] zdbjq = {"半程组别终点补给", "迷你组别终点补给"};

        int parentId6 = 2523;
        String[] jsq = {"起终点区", "沿途计时点"};

        int parentId7 = 2524;
        String[] ccq = {"半程组别", "迷你组别"};

        int parentId8 = 2526;
        String[] tcczy = {"大众选手停车指引", "VIP停车场指引"};

        int parentId9 = 2527;
        String[] ytycylbjz = {"沿途10个水站"};

        insertChildren(parentId, wenxunche);
        insertChildren(parentId1, jijeche);
        insertChildren(parentId2, tyxs);
        insertChildren(parentId3, gyq);
        insertChildren(parentId4, cbq);
        insertChildren(parentId5, zdbjq);
        insertChildren(parentId6, jsq);
        insertChildren(parentId7, ccq);
        insertChildren(parentId8, tcczy);
        insertChildren(parentId9, ytycylbjz);
    }

    private void insertChildren(int parentId, String[] wenxunche) {
        for (int i = 1; i <= wenxunche.length; i++) {
            SysDictInfo sysDictInfo = new SysDictInfo();
            sysDictInfo.setId(parentId * 10 + i);
            sysDictInfo.setVal(wenxunche[i - 1]);
            sysDictInfo.setSortno(i);
            sysDictInfo.setParent(parentId);
            sysDictInfoMapper.insertSelective(sysDictInfo);
        }
    }

    @Test
    public void testInitVolunteer() {
        String marathonId = "d2880653-cd8b-405b-bcc9-28cccb1008b6";
        volunteerService.deleteVolunteers(marathonId);
        volunteerService.initVolunteers(marathonId);

    }
}
