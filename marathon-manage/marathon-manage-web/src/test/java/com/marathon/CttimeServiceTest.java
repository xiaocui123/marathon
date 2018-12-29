/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.marathon;

import com.marathon.manage.refactor.pojo.PointsFLow;
import com.marathon.manage.refactor.pojo.RunnerInfo;
import com.marathon.manage.refactor.pojo.RunnerInfoExample;
import com.marathon.manage.service.TimingResultService;
import com.marathon.timing.TimingConstants;
import com.marathon.timing.service.CttimeService;
import com.marathon.timing.service.RunnerService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * @author cui
 * @version CttimeServiceTest, v0.1 2018/12/12 9:44
 */
public class CttimeServiceTest extends AbstractSpringTest {

    @Autowired
    private CttimeService cttimeService;

    @Autowired
    private TimingResultService timingResultService;

    @Autowired
    private RunnerService runnerService;

    @Test
    public void testSaveExcel(){
        cttimeService.saveResult2Excel();
    }

    @Test
    public void testRunner(){
        List<PointsFLow> lstPointFlow=cttimeService.getPointFlow(1);

        RunnerInfoExample example=new RunnerInfoExample();
        example.or().andTagEqualTo(42031);
        List<RunnerInfo> lstRunner = runnerService.queryRunners(example);

        Map<String, Object> objectMap = cttimeService.calcResult(lstRunner.get(0),lstPointFlow,1);
        System.out.println(objectMap);
    }

}
