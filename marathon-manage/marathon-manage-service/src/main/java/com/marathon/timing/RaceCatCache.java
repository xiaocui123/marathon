/*
 * @Copyright: 2005-2018 www.hyjf.com. All rights reserved.
 */
package com.marathon.timing;

import com.google.common.base.Function;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Lists;
import com.marathon.manage.refactor.pojo.RaceCatMaster;
import com.marathon.timing.service.CttimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * 比赛组别缓存
 *
 * @author cui
 * @version RaceCatCache, v0.1 2019/1/3 15:08
 */
@Service
public class RaceCatCache {

    @Autowired
    private CttimeService cttimeService;

    //cat中文名称缓存
    LoadingCache<String, String> cache = CacheBuilder.newBuilder()
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String s) throws Exception {
                    for (RaceCatMaster raceCat : cttimeService.getRaceCatMaster()) {
                        if (s.equalsIgnoreCase(raceCat.getRacecat())) {
                            return raceCat.getRacecatnamechi();
                        }
                    }
                    return s;
                }
            });

    public String getCatChinese(String cat) throws ExecutionException {
        return cache.get(cat);
    }

    public List<RaceCatMaster> getRaceCats() {
        return cttimeService.getRaceCatMaster();
    }

}
