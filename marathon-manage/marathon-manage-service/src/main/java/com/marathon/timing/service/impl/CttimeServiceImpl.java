/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.marathon.timing.service.impl;

import com.marathon.manage.refactor.mapper.CttimesInfoMapper;
import com.marathon.manage.refactor.pojo.CttimesInfo;
import com.marathon.manage.refactor.pojo.CttimesInfoExample;
import com.marathon.timing.service.CttimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author cui
 * @version CttimeServiceImpl, v0.1 2018/12/12 9:43
 */
@Service
public class CttimeServiceImpl implements CttimeService {

    @Autowired
    private CttimesInfoMapper cttimesInfoMapper;

    @Override
    public List<CttimesInfo> query() {
        return cttimesInfoMapper.selectByExample(new CttimesInfoExample());
    }
}
