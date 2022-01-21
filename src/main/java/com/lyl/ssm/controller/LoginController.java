package com.lyl.ssm.controller;

import com.lyl.ssm.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    @RequestMapping("/login")
    public String toLogin() {
        return "/login/login";
    }


}
