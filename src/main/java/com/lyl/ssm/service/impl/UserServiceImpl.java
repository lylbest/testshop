package com.lyl.ssm.service.impl;

import com.lyl.ssm.base.BaseDao;
import com.lyl.ssm.base.BaseServiceImpl;
import com.lyl.ssm.mapper.UserMapper;
import com.lyl.ssm.po.User;
import com.lyl.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
    @Autowired
    private UserMapper userMapper;


    @Override
    public BaseDao<User> getBaseDao() {
        return userMapper;
    }
}
