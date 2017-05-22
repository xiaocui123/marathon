package com.marathon.manage.qvo;

import com.google.common.collect.Lists;
import com.marathon.manage.pojo.MarathonMediaActivity;

import java.util.List;

/**
 * Created by cui on 2017/5/19.
 * 添加媒体活动请求对象
 */
public class AddMediaActivityQO extends MarathonMediaActivity {

    private List<String> lstFileResourceId;

    public List<String> getLstFileResourceId() {
        if (lstFileResourceId == null) {
            lstFileResourceId = Lists.newArrayList();
        }
        return lstFileResourceId;
    }

    public void setLstFileResourceId(List<String> lstFileResourceId) {
        this.lstFileResourceId = lstFileResourceId;
    }
}
