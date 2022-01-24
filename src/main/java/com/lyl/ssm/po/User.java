package com.lyl.ssm.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String passWord;
    /*
    电话号码
     */
    private String phone;
    /**
     * 真实姓名
     */
    private String reaName;
    /**
     * 性别
     */
    private String sex;

    /**
     * 地址
     */
    private String address;
    /**
     * 电子邮箱
     */
    private String email;


}
