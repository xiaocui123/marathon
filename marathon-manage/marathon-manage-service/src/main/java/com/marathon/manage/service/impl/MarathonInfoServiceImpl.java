package com.marathon.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.marathon.manage.mapper.MarathonInfoMapper;
import com.marathon.manage.pojo.MarathonInfo;
import com.marathon.manage.service.MarathonInfoService;
import com.marathon.manage.vo.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by cui on 2017/5/16.
 */
@Service("MarathonInfoService")
public class MarathonInfoServiceImpl implements MarathonInfoService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MarathonInfoMapper marathonInfoMapper;

    @Override
    public int addMarathon(MarathonInfo marathonInfo) {
        if (marathonInfo.getMarathonUuid() == null) {
            marathonInfo.setMarathonUuid(UUID.randomUUID().toString());
        }
        return marathonInfoMapper.insertSelective(marathonInfo);
    }

    @Override
    public List<MarathonInfo> queryForAll(Page<MarathonInfo> page) {
        PageHelper.offsetPage(page.getOffset(), page.getLimit());
        List<MarathonInfo> lstMarathon = marathonInfoMapper.queryAllMarathons();
        com.github.pagehelper.Page<MarathonInfo> result = (com.github.pagehelper.Page<MarathonInfo>) lstMarathon;
        page.setTotal((int) result.getTotal());
        page.setRows(result.getResult());
        return lstMarathon;
    }
}
