package com.lyl.ssm.controller;

import com.lyl.ssm.base.BaseController;
import com.lyl.ssm.po.Manage;
import com.lyl.ssm.service.ManageService;
import com.lyl.ssm.utils.Consts;
import oracle.jdbc.driver.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    @Autowired
    ManageService manageService;




    @RequestMapping("/login")
    public String Login() {
        return "/login/mLogin";
    }

    @RequestMapping("/toLogin")
    public String toLogin(Manage manage, HttpServletRequest request){
        Manage byEntity = manageService.getByEntity(manage);
        if (byEntity==null){
        return "redirect:/login/mtuichu";
        }
        request.getSession().setAttribute(Consts.MANAGE,byEntity);
        return "/login/mIndex";
    }

    @RequestMapping("/mtuichu")
    public String mtuichu(HttpServletRequest request){
//        清空session
        request.getSession().setAttribute(Consts.MANAGE,null);
        return "/login/mLogin";
    }

}
