package com.marathon.manage.controller;

import com.marathon.manage.MarathonConstants;
import com.marathon.manage.pojo.UserInfo;
import com.marathon.manage.vo.BaseResultBean;
import com.marathon.manage.vo.ResultEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by cui on 2017/5/17.
 */
@Controller
@RequestMapping("sys")
public class SysController {

    @RequestMapping("/login")
    @ResponseBody
    public BaseResultBean login(UserInfo userInfo, HttpServletRequest request) {
        BaseResultBean result = new BaseResultBean();
        UsernamePasswordToken token = new UsernamePasswordToken(userInfo.getUserAccount(),
                userInfo.getUserPsw());
        Subject loginUser = SecurityUtils.getSubject();
        try {
            loginUser.login(token);
            UserInfo usr = (UserInfo) loginUser.getPrincipal();
            request.getSession().setAttribute(MarathonConstants.SYSTEM_USER, usr);
            request.getSession().setAttribute(MarathonConstants.SYSTEM_USER_ID, usr.getUserId());
        } catch (AuthenticationException e) {
            result.setEnum(ResultEnum.SUCCESS);
        }
        return result;
    }

    @RequestMapping("gotoSys")
    public String gotoSys() {
        return "index";
    }

    @RequestMapping("/logout")
    public String logout() {
        if (SecurityUtils.getSubject().isAuthenticated()) {
            SecurityUtils.getSubject().logout();
        }
        return "redirect:/login.jsp";
    }
}
