package com.lyl.ssm.controller;

import com.lyl.ssm.po.ItemCategory;
import com.lyl.ssm.service.ItemCategoryService;
import com.lyl.ssm.utils.Pager;
import com.sun.mail.imap.protocol.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/itemCategory")
public class ItemCategoryController {

    @Autowired
    private ItemCategoryService itemCategoryService;


    /**
     * 分页查询类目列表
     */
    @RequestMapping("/findBySql")
    public String findBySql(Model model, ItemCategory itemCategory) {
        String sql = "select * from item_category where isDelete=0 and pid is null order by id";
        Pager<ItemCategory> pagers = itemCategoryService.findBySqlRerturnEntity(sql);
        List<ItemCategory> datas = pagers.getDatas();
        model.addAttribute("pagers", pagers);
        model.addAttribute("itemCategory", itemCategory);
        return "itemCategory/itemCategory";
    }

    /**
     * 转向新增一级类目页面
     * @return
     */
    @RequestMapping("/add")
    public String add(){
        return "itemCategory/add";
    }

    /**
     * 新增一级类目保存功能
     *
     */
    @RequestMapping("/exAdd")
    public String exAdd(ItemCategory itemCategory){
        itemCategory.setIsDelete(0);
        itemCategoryService.insert(itemCategory);
        return "redirect:/itemCategory/findBySql.action";
    }
    /**
     * 转到修改一级类目页面
     * @return
     */
    @RequestMapping("/update")
    public String update(Integer id,Model model){
        ItemCategory obj = itemCategoryService.load(id);
        model.addAttribute("obj",obj);
        return "itemCategory/update";
    }

    /**
     * 执行更新操作
     * @param itemCategory
     * @return
     */
    @RequestMapping("/exUpdate")
    public String exUpdate(ItemCategory itemCategory){
        itemCategoryService.updateById(itemCategory);
        return "redirect:/itemCategory/findBySql.action";
    }
    /**
     * 一级类目的删除操作
     */

    @RequestMapping("/delete")
    public String delete(Integer id){
        ItemCategory load = itemCategoryService.load(id);
        load.setIsDelete(1);
        itemCategoryService.updateById(load);
        //有下级目录时，一并删除
        String sql="update item_category set isDelete=1 where pid="+id;
        itemCategoryService.updateBysql(sql);
        return "redirect:/itemCategory/findBySql.action";
    }
    /**
     * 查看二级类目信息
     */
    @RequestMapping("/findBySql2")
    public String findBySql2(ItemCategory itemCategory,Model model){
        String sql="select * from item_category where isDelete=0 and pid="+itemCategory.getPid()+" order by id";
        Pager<ItemCategory> pagers = itemCategoryService.findBySqlRerturnEntity(sql);
        model.addAttribute("pagers",pagers);
        model.addAttribute("obj",itemCategory);
        return "itemCategory/itemCategory2";
    }

    /**
     * 转向新增二级类目页面
     * @return
     */
    @RequestMapping("/add2")
    public String add2(Integer pid,Model model){
        model.addAttribute("pid",pid);
        return "itemCategory/add2";
    }
    /**
     * 新增二级类目保存功能
     *
     */
    @RequestMapping("/exAdd2")
    public String exAdd2(ItemCategory itemCategory){
        itemCategory.setIsDelete(0);
        System.out.println(itemCategory);
        itemCategoryService.insert(itemCategory);
        return "redirect:/itemCategory/findBySql2.action?pid="+ itemCategory.getPid();
    }
    /**
     * 转到修改一级类目页面
     * @return
     */
    @RequestMapping("/update2")
    public String update2(Integer id,Model model){
        ItemCategory obj = itemCategoryService.load(id);
        model.addAttribute("obj",obj);
        return "itemCategory/update2";
    }

    /**
     * 执行更新操作
     * @param itemCategory
     * @return
     */
    @RequestMapping("/exUpdate2")
    public String exUpdate2(ItemCategory itemCategory){
        itemCategoryService.updateById(itemCategory);
        return "redirect:/itemCategory/findBySql2.action?pid="+itemCategory.getPid();
    }
    @RequestMapping("/delete2")
    public String delete2(Integer id,Integer pid){
        ItemCategory load = itemCategoryService.load(id);
        load.setIsDelete(1);
        itemCategoryService.updateById(load);
        return "redirect:/itemCategory/findBySql2.action?pid="+pid;
    }

}
