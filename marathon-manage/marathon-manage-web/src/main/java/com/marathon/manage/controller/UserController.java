package com.marathon.manage.controller;

import com.marathon.manage.pojo.UserInfo;
import com.marathon.manage.service.UserInfoService;
import com.marathon.manage.vo.JSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by cui on 2017/5/27.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("add")
    @ResponseBody
    public UserInfo add(@RequestBody UserInfo userInfo) {
        userInfoService.add(userInfo);
        return userInfo;
    }

    @RequestMapping("update")
    @ResponseBody
    public JSONResult update(@RequestBody UserInfo userInfo) {
        JSONResult result = new JSONResult();
        userInfoService.update(userInfo);
        return result;
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    @ResponseBody
    public JSONResult delete(@RequestParam String userId) {
        JSONResult result = new JSONResult();
        userInfoService.delete(userId);
        return result;
    }

    @RequestMapping(value = "queryById", method = RequestMethod.GET)
    @ResponseBody
    public UserInfo queryById(@RequestParam("userId") String userId) {
        return userInfoService.queryById(userId);
    }
}
