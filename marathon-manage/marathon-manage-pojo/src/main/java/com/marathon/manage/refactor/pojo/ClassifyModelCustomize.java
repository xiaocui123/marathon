package com.marathon.manage.refactor.pojo;

import com.google.common.base.MoreObjects;
import com.google.common.collect.Lists;

import java.util.List;

/**
 * 业务模型配置类
 * Created by cui on 2018/4/29.
 */
public class ClassifyModelCustomize {
    //与数据字典中一致
    private Integer id;

    //与数据字典中一致
    private String name;

    //排序号
    private Integer sortNo;

    private List<ActivityModelCustomize> lstActivity;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public List<ActivityModelCustomize> getLstActivity() {
        if (lstActivity == null) {
            lstActivity = Lists.newArrayList();
        }
        return lstActivity;
    }

    public void setLstActivity(List<ActivityModelCustomize> lstActivity) {
        this.lstActivity = lstActivity;
    }

    public class ActivityModelCustomize {
        private String name;

        private Integer sortNo;

        //活动预估花费时间（单位 天）
        private Integer estimateCycle;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getSortNo() {
            return sortNo;
        }

        public void setSortNo(Integer sortNo) {
            this.sortNo = sortNo;
        }

        public Integer getEstimateCycle() {
            return estimateCycle;
        }

        public void setEstimateCycle(Integer estimateCycle) {
            this.estimateCycle = estimateCycle;
        }

        @Override
        public String toString() {
            return MoreObjects.toStringHelper(this).add("name",name)
                    .add("sortNo",sortNo).toString();
        }
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this).add("id", id)
                .add("name", name)
                .add("sordNo", sortNo)
                .add("lstActivity", lstActivity).toString();
    }
}
