package com.marathon.manage.refactor.mapper;

import com.marathon.manage.refactor.pojo.MarathonActivityClassify;
import com.marathon.manage.refactor.pojo.MarathonActivityClassifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MarathonActivityClassifyMapper {
    int deleteByPrimaryKey(String marathonActivityclassifyUuid);

    int insert(MarathonActivityClassify record);

    int insertSelective(MarathonActivityClassify record);

    List<MarathonActivityClassify> selectByExample(MarathonActivityClassifyExample example);

    MarathonActivityClassify selectByPrimaryKey(String marathonActivityclassifyUuid);

    int updateByExampleSelective(@Param("record") MarathonActivityClassify record, @Param("example") MarathonActivityClassifyExample example);

    int updateByExample(@Param("record") MarathonActivityClassify record, @Param("example") MarathonActivityClassifyExample example);

    int updateByPrimaryKeySelective(MarathonActivityClassify record);

    int updateByPrimaryKey(MarathonActivityClassify record);

    void deleteByMarathonId(String marathonUuid);
}