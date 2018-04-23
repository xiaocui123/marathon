package com.marathon.manage.controller;

import com.marathon.manage.refactor.mapper.SysDictInfoMapper;
import com.marathon.manage.refactor.pojo.SysDictInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by cui on 2017/6/26.
 */
@RequestMapping("/dict")
@Controller
public class SysDictController {
    @Autowired
    private SysDictInfoMapper sysDictMapper;

    @RequestMapping(value = "getDict", method = RequestMethod.POST)
    @ResponseBody
    public List<SysDictInfo> getDict(@RequestBody List<String> lstParentId) {
        return sysDictMapper.getDicts(lstParentId);
    }
}
