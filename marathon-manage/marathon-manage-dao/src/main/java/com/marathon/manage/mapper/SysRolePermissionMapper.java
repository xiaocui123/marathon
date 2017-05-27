package com.marathon.manage.mapper;

import com.marathon.manage.pojo.SysRolePermission;

public interface SysRolePermissionMapper {
    int deleteByPrimaryKey(String rpId);

    int insert(SysRolePermission record);

    int insertSelective(SysRolePermission record);

    SysRolePermission selectByPrimaryKey(String rpId);

    int updateByPrimaryKeySelective(SysRolePermission record);

    int updateByPrimaryKey(SysRolePermission record);
}