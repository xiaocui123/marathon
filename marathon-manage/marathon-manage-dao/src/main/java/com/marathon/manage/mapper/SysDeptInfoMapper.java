package com.marathon.manage.mapper;

import com.marathon.manage.pojo.DeptUserTreeVO;
import com.marathon.manage.pojo.SysDeptInfo;

import java.util.List;

public interface SysDeptInfoMapper {
    int deleteByPrimaryKey(String departmentId);

    int insert(SysDeptInfo record);

    int insertSelective(SysDeptInfo record);

    SysDeptInfo selectByPrimaryKey(String departmentId);

    int updateByPrimaryKeySelective(SysDeptInfo record);

    int updateByPrimaryKey(SysDeptInfo record);

    List<DeptUserTreeVO> queryTree();
}