package com.marathon.timing.service;

import com.marathon.manage.refactor.pojo.RunnerInfo;
import com.marathon.manage.refactor.pojo.RunnerInfoExample;

import java.util.List;

/**
 * @author cui
 * @version RunnerService, v0.1 2018/12/24 11:43
 */
public interface RunnerService {

    List<RunnerInfo> queryRunners(RunnerInfoExample example);

}
