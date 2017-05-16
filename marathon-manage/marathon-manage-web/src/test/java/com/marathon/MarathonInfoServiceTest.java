package com.marathon;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.marathon.manage.pojo.MarathonInfo;
import com.marathon.manage.service.MarathonInfoService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by cui on 2017/5/16.
 */
public class MarathonInfoServiceTest extends AbstractSpringTest {

    @Autowired
    private MarathonInfoService marathonInfoService;

    @Test
    public void testInsert() {
        for (int i = 0; i < 100; i++) {
            MarathonInfo info = new MarathonInfo();
            info.setMarathonName("marathon_" + i);
            info.setMarathonCreater("test");
            info.setMarathonAddress("where");
            marathonInfoService.addMarathon(info);
        }
    }


    @Test
    public void testQueryForAll() {
        com.marathon.manage.vo.Page<MarathonInfo> page=new com.marathon.manage.vo.Page<>();
        page.setOffset(0);
        page.setLimit(10);
        List<MarathonInfo> result = marathonInfoService.queryForAll(page);

        System.out.println("total:" + ((Page) result).getTotal() + " size:" + ((Page) result).getResult().size());
        System.out.println(result);
    }
}
