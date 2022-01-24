package com.lyl.ssm.controller;

import com.lyl.ssm.base.BaseController;
import com.lyl.ssm.po.User;
import com.lyl.ssm.service.UserService;
import com.lyl.ssm.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @RequestMapping("/findBySql")
    public String findBySql(Model model,User user) {
        String sql = "select * from user where 1=1 ";
        if (!isEmpty(user.getUserName())){
            sql+=" and userName like '%"+user.getUserName()+"%' ";
        }
        sql+=" order by id ";



        Pager<User> pagers = userService.findBySqlRerturnEntity(sql);
        model.addAttribute("pagers", pagers);
        model.addAttribute("obj",user);
        return "user/user";
    }


}
