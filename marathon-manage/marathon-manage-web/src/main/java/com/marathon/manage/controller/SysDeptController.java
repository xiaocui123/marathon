package com.marathon.manage.controller;

import com.marathon.manage.pojo.DeptUserTreeVO;
import com.marathon.manage.pojo.SysDeptInfo;
import com.marathon.manage.service.SysDeptInfoService;
import com.marathon.manage.vo.BaseResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by cui on 2017/5/27.
 */
@Controller
@RequestMapping("/department")
public class SysDeptController {
    @Autowired
    private SysDeptInfoService sysDeptInfoService;

    @RequestMapping("init")
    public String init(){
        return "sys/department";
    }

    @RequestMapping("add")
    @ResponseBody
    public SysDeptInfo add(@RequestBody SysDeptInfo sysDeptInfo) {
        sysDeptInfoService.add(sysDeptInfo);
        return sysDeptInfo;
    }

    @RequestMapping("update")
    @ResponseBody
    public BaseResultBean udpate(@RequestBody SysDeptInfo sysDeptInfo) {
        BaseResultBean result = new BaseResultBean();
        sysDeptInfoService.update(sysDeptInfo);
        return result;
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    @ResponseBody
    public BaseResultBean delete(@RequestParam("deptId") String deptId) {
        BaseResultBean result = new BaseResultBean();
        sysDeptInfoService.delete(deptId);
        return result;
    }

    @RequestMapping(value = "queryTree", method = RequestMethod.GET)
    @ResponseBody
    public List<DeptUserTreeVO> queryTree() {
        return sysDeptInfoService.queryDeptUser();
    }
}
