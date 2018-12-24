/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.marathon;

import com.marathon.manage.service.TimingResultService;
import com.marathon.timing.TimingConstants;
import com.marathon.timing.service.CttimeService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author cui
 * @version CttimeServiceTest, v0.1 2018/12/12 9:44
 */
public class CttimeServiceTest extends AbstractSpringTest {

    @Autowired
    private CttimeService cttimeService;

    @Autowired
    private TimingResultService timingResultService;

    @Test
    public void testSaveExcel(){
        cttimeService.saveResult2Excel();
    }

    @Test
    public void testQuery(){
        System.out.println(cttimeService.queryResult(TimingConstants.DEFAULT_RESULT_TABLE_NAME));
    }

}
