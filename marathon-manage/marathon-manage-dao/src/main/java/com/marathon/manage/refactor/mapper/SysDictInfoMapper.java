package com.marathon.manage.refactor.mapper;

import com.marathon.manage.refactor.pojo.SysDictInfo;
import com.marathon.manage.refactor.pojo.SysDictInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysDictInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SysDictInfo record);

    int insertSelective(SysDictInfo record);

    List<SysDictInfo> selectByExample(SysDictInfoExample example);

    SysDictInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysDictInfo record, @Param("example") SysDictInfoExample example);

    int updateByExample(@Param("record") SysDictInfo record, @Param("example") SysDictInfoExample example);

    int updateByPrimaryKeySelective(SysDictInfo record);

    int updateByPrimaryKey(SysDictInfo record);

    List<SysDictInfo> getDicts(List<String> parentIds);
}