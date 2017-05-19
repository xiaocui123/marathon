package com.marathon;

import com.marathon.manage.pojo.MarathonMediaActivity;
import com.marathon.manage.service.MediaActivityService;
import com.marathon.manage.vo.Page;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by cui on 2017/5/18.
 */
public class MediaActivityServiceTest extends AbstractSpringTest {

    @Autowired
    private MediaActivityService mediaActivityService;

    @Test
    public void testInsert() {
        for (int i = 0; i < 10; i++) {
            MarathonMediaActivity activity = new MarathonMediaActivity();
            activity.setMarathonUuid("1b400f25-3843-40ad-8687-f16ffeb53f9f");
            activity.setMediaActivityType("0");
            mediaActivityService.addActivity(activity);
        }
    }

    @Test
    public void testQueryByMarathon() {
        Page<MarathonMediaActivity> page = new Page<>();
        page.setOffset(0);
        page.setLimit(5);
        List<MarathonMediaActivity> lstActivity = mediaActivityService.queryActivityByMarathon("1b400f25-3843-40ad-8687-f16ffeb53f9f", "0", page);
        System.out.println(lstActivity.size());
    }
}
