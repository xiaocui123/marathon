package com.marathon;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.marathon.manage.pojo.MarathonMediaActivity;
import com.marathon.manage.refactor.pojo.ClassifyModelCustomize;
import com.marathon.manage.service.MediaActivityService;
import com.marathon.manage.utils.MarathonModelParser;
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

    @Test
    public void testClassifyModel(){
        ClassifyModelCustomize modelCustomize=new ClassifyModelCustomize();
        modelCustomize.setId(2501);
        modelCustomize.setName("竞赛及物资");
        modelCustomize.setSortNo(1);

        ClassifyModelCustomize.ActivityModelCustomize activityModelCustomize=modelCustomize.new ActivityModelCustomize();
        activityModelCustomize.setName("活动一");
        activityModelCustomize.setSortNo(1);
        modelCustomize.getLstActivity().add(activityModelCustomize);

        ClassifyModelCustomize.ActivityModelCustomize activityModelCustomize2=modelCustomize.new ActivityModelCustomize();
        activityModelCustomize2.setName("活动二");
        activityModelCustomize2.setSortNo(2);
        modelCustomize.getLstActivity().add(activityModelCustomize2);

        System.out.println(new Gson().toJson(modelCustomize));
    }

    @Test
    public void testJsonParser(){
        System.out.println(MarathonModelParser.getClassifyModel());
    }

}
