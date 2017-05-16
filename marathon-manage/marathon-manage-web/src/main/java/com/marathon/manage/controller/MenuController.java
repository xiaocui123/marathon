package com.marathon.manage.controller;

import com.google.common.collect.Lists;
import com.marathon.manage.qvo.MenuVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

/**
 * Created by cui on 2017/4/25.
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @RequestMapping("/getMenuMenu")
    @ResponseBody
    public List<MenuVO> getMenu(HttpServletRequest request, HttpServletResponse response) {
        List<MenuVO> lstMenu = Lists.newArrayList();
        MenuVO menuVO = new MenuVO();
        menuVO.setUuid(UUID.randomUUID().toString());
        menuVO.setName("赛事管理");
        menuVO.setIconCls("glyphicon glyphicon-book");
        menuVO.setUrl("marathoninfo/init");
        lstMenu.add(menuVO);

        MenuVO menuVO2 = new MenuVO();
        menuVO2.setName("媒体服务");
        menuVO2.setIconCls("glyphicon glyphicon-earphone");
        menuVO2.setUuid(UUID.randomUUID().toString());
        menuVO2.setUrl("media/init");
        lstMenu.add(menuVO2);

        return lstMenu;
    }

    @RequestMapping("/init")
    public String init() {
        return "welcome";
    }
}
