package com.marathon.manage.service.volunteer;

import com.marathon.manage.refactor.mapper.SysDictInfoMapper;
import com.marathon.manage.refactor.mapper.VolunteerInfoMapper;
import com.marathon.manage.refactor.pojo.SysDictInfo;
import com.marathon.manage.refactor.pojo.SysDictInfoExample;
import com.marathon.manage.refactor.pojo.VolunteerInfo;
import com.marathon.manage.refactor.pojo.VolunteerInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by cui on 2018/5/22.
 */
@Service
public class VolunteerServiceImpl implements VolunteerService {

    @Autowired
    private VolunteerInfoMapper volunteerInfoMapper;

    @Autowired
    private SysDictInfoMapper sysDictInfoMapper;

    @Override
    public List<VolunteerInfo> queryForVolunteers(String marathonId) {
        VolunteerInfoExample example = new VolunteerInfoExample();
        example.or().andMarathonIdEqualTo(marathonId);
        return volunteerInfoMapper.selectByExample(example);
    }

    @Override
    public void initVolunteers(String marathonId) {
        SysDictInfoExample example = new SysDictInfoExample();
        example.or().andParentEqualTo(251);
        List<SysDictInfo> lstGroup = sysDictInfoMapper.selectByExample(example);
        for (SysDictInfo group : lstGroup) {
            SysDictInfoExample infoExample = new SysDictInfoExample();
            infoExample.or().andParentEqualTo(group.getId());
            List<SysDictInfo> lstLocation = sysDictInfoMapper.selectByExample(infoExample);

            if (lstLocation.size() > 0) {
                for (SysDictInfo location : lstLocation) {
                    VolunteerInfo volunteerInfo = new VolunteerInfo();
                    volunteerInfo.setId(UUID.randomUUID().toString());
                    volunteerInfo.setMarathonId(marathonId);
                    volunteerInfo.setGroupId(group.getId());
                    volunteerInfo.setLocationId(location.getId());
                    volunteerInfoMapper.insertSelective(volunteerInfo);
                }
            } else {
                VolunteerInfo volunteerInfo = new VolunteerInfo();
                volunteerInfo.setId(UUID.randomUUID().toString());
                volunteerInfo.setMarathonId(marathonId);
                volunteerInfo.setGroupId(group.getId());
                volunteerInfoMapper.insertSelective(volunteerInfo);
            }
        }
    }

    @Override
    public void deleteVolunteers(String marathonId) {
        volunteerInfoMapper.deleteByMarathonId(marathonId);
    }
}
