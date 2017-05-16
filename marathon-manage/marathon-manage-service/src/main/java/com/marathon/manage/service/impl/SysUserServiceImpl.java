package com.marathon.manage.service.impl;


import com.marathon.manage.mapper.SysUserMapper;
import com.marathon.manage.pojo.SysUser;
import com.marathon.manage.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SysUserServiceImpl implements SysUserService {
	
	@Resource
	private SysUserMapper sysUserMapper;


	@Override
	public SysUser getById(Long id) {
		return sysUserMapper.selectByPrimaryKey(id);
	}
}
