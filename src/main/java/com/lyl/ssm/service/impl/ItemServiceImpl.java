package com.lyl.ssm.service.impl;

import com.lyl.ssm.base.BaseDao;
import com.lyl.ssm.base.BaseServiceImpl;
import com.lyl.ssm.mapper.ItemMapper;
import com.lyl.ssm.po.Item;
import com.lyl.ssm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl extends BaseServiceImpl<Item> implements ItemService {
    @Autowired
    private ItemMapper itemMapper;




    @Override
    public BaseDao<Item> getBaseDao() {
        return itemMapper;
    }
}
