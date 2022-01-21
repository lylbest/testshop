package com.lyl.ssm.service.impl;

import com.lyl.ssm.base.BaseDao;
import com.lyl.ssm.base.BaseServiceImpl;
import com.lyl.ssm.mapper.ManageMapper;
import com.lyl.ssm.po.Manage;
import com.lyl.ssm.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManageServiceImpl extends BaseServiceImpl<Manage> implements ManageService {
    @Autowired
    ManageMapper manageMapper;




    @Override
    public BaseDao<Manage> getBaseDao() {
        return manageMapper;
    }
}
