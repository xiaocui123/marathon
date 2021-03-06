package com.marathon.manage.service.impl;

import com.marathon.manage.mapper.SysDeptInfoMapper;
import com.marathon.manage.pojo.DeptUserTreeVO;
import com.marathon.manage.pojo.SysDeptInfo;
import com.marathon.manage.service.SysDeptInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by cui on 2017/5/27.
 */
@Service("SysDeptInfoService")
public class SysDeptInfoServiceImpl implements SysDeptInfoService {

    @Autowired
    private SysDeptInfoMapper sysDeptInfoMapper;

    @Override
    public int add(SysDeptInfo sysDeptInfo) {
        if (sysDeptInfo.getDepartmentId() == null) {
            sysDeptInfo.setDepartmentId(UUID.randomUUID().toString());
        }
        return sysDeptInfoMapper.insertSelective(sysDeptInfo);
    }

    @Override
    public int update(SysDeptInfo sysDeptInfo) {
        return sysDeptInfoMapper.updateByPrimaryKeySelective(sysDeptInfo);
    }

    @Override
    public int delete(String deptId) {
        return sysDeptInfoMapper.deleteByPrimaryKey(deptId);
    }

    @Override
    public List<DeptUserTreeVO> queryDeptUser() {
        return sysDeptInfoMapper.queryTree();
    }
}
