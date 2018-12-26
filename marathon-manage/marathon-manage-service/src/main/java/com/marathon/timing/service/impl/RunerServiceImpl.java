/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.marathon.timing.service.impl;

import com.marathon.manage.refactor.mapper.RunnerInfoMapper;
import com.marathon.manage.refactor.pojo.RunnerInfo;
import com.marathon.manage.refactor.pojo.RunnerInfoExample;
import com.marathon.timing.TimingConstants;
import com.marathon.timing.service.RunnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cui
 * @version RunerServiceImpl, v0.1 2018/12/24 11:44
 */
@Service
public class RunerServiceImpl implements RunnerService {

    @Autowired
    private RunnerInfoMapper runnerInfoMapper;

    @Override
    public List<RunnerInfo> queryRunners(RunnerInfoExample example) {
        List<RunnerInfo> lstRunner = runnerInfoMapper.selectByExample(example);
        return lstRunner;
    }
}
