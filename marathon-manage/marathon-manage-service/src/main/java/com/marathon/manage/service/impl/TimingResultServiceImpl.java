/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.marathon.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.marathon.manage.refactor.mapper.TimingResultMapper;
import com.marathon.manage.service.TimingResultService;
import com.marathon.manage.vo.Page;
import com.marathon.timing.TimingConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author cui
 * @version TimingResultServiceImpl, v0.1 2018/12/24 11:30
 */
@Service
public class TimingResultServiceImpl implements TimingResultService {

    @Autowired
    private TimingResultMapper timingResultMapper;

    @Override
    public boolean existTable(String tableName) {
        return timingResultMapper.existTable(TimingConstants.DEFAULT_RESULT_TABLE_NAME) > 0;
    }

    @Override
    public int dropTable(String tableName) {
        return timingResultMapper.dropTable(TimingConstants.DEFAULT_RESULT_TABLE_NAME);
    }

    @Override
    public void createTimingResult(String tableName, List<String> cloums) {
        timingResultMapper.createTimingResult(tableName, cloums);
    }

    @Override
    public void saveResult(String tableName, Map<String, String> params) {
        timingResultMapper.saveResult(TimingConstants.DEFAULT_RESULT_TABLE_NAME, params);
    }

    @Override
    public void queryForAll(Page<Map<String, Object>> page) {
        PageHelper.offsetPage(page.getOffset(), page.getLimit());
        List<Map<String, Object>> lstResult = timingResultMapper.selectTimingResult(TimingConstants.DEFAULT_RESULT_TABLE_NAME);
        com.github.pagehelper.Page<Map<String,Object>> result = (com.github.pagehelper.Page<Map<String,Object>>) lstResult;
        page.setTotal((int) result.getTotal());
        page.setRows(result.getResult());
    }
}
