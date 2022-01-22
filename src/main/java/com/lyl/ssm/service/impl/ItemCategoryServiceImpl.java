package com.lyl.ssm.service.impl;

import com.lyl.ssm.base.BaseDao;
import com.lyl.ssm.base.BaseServiceImpl;
import com.lyl.ssm.mapper.ItemCategoryMapper;
import com.lyl.ssm.po.ItemCategory;
import com.lyl.ssm.service.ItemCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemCategoryServiceImpl extends BaseServiceImpl<ItemCategory> implements ItemCategoryService {
    @Autowired
    ItemCategoryMapper itemCategoryMapper;


    @Override
    public BaseDao<ItemCategory> getBaseDao() {
        return itemCategoryMapper;
    }
}
