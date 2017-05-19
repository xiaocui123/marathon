package com.marathon.manage.service.impl;

import com.github.pagehelper.PageHelper;
import com.marathon.manage.mapper.MarathonMediaActivityMapper;
import com.marathon.manage.pojo.MarathonMediaActivity;
import com.marathon.manage.service.MediaActivityService;
import com.marathon.manage.vo.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Created by cui on 2017/5/17.
 */
@Service("MediaActivityService")
public class MediaActivityServiceImpl implements MediaActivityService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MarathonMediaActivityMapper mediaActivityMapper;

    @Override
    public int addActivity(MarathonMediaActivity activity) {
        if (activity.getMediaActivityUuid() == null) {
            activity.setMediaActivityUuid(UUID.randomUUID().toString());
        }
        return mediaActivityMapper.insert(activity);
    }

    @Override
    public List<MarathonMediaActivity> queryActivityByMarathon(String marathonId, String activityType, Page<MarathonMediaActivity> page) {
        PageHelper.offsetPage(page.getOffset(), page.getLimit());
        List<MarathonMediaActivity> result = mediaActivityMapper.queryByMarathon(marathonId, activityType);
        com.github.pagehelper.Page<MarathonMediaActivity> githubPage = (com.github.pagehelper.Page<MarathonMediaActivity>) result;
        page.setTotal((int) githubPage.getTotal());
        page.setRows(githubPage.getResult());
        return result;
    }
}
