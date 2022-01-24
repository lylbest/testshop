package com.lyl.ssm.controller;

import com.lyl.ssm.base.BaseController;
import com.lyl.ssm.po.Item;
import com.lyl.ssm.service.ItemService;
import com.lyl.ssm.utils.Pager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/item")
public class ItemController extends BaseController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/findBySql")
    public String findBySql(Model model, Item item) {
        String sql = "select * from item where isDelete=0 ";
        if (!isEmpty(item.getName())) {
            sql += " and name like '%" + item.getName() + "%' ";
        }

        sql += " order by id ";
        Pager<Item> pagers = itemService.findBySqlRerturnEntity(sql);
        model.addAttribute("pagers", pagers);
        model.addAttribute("obj", item);
        return "item/item";
    }


}
