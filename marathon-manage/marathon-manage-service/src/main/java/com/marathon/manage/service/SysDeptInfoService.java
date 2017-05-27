package com.marathon.manage.service;

import com.marathon.manage.pojo.DeptUserTreeVO;
import com.marathon.manage.pojo.SysDeptInfo;

import java.util.List;

/**
 * Created by cui on 2017/5/27.
 */
public interface SysDeptInfoService {

    int add(SysDeptInfo sysDeptInfo);

    int update(SysDeptInfo sysDeptInfo);

    int delete(String deptId);

    /**
     * 查询系统内部门人员树
     * @return
     */
    List<DeptUserTreeVO> queryDeptUser();

}
