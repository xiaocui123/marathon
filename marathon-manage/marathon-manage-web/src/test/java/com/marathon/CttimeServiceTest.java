/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.marathon;

import com.marathon.manage.config.ds.DataSourceAop;
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

    @Test
    public void testQuery(){
        System.out.println(getBean(DataSourceAop.class));
        System.out.println(cttimeService.query().size());
    }

}
