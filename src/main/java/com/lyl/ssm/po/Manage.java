package com.lyl.ssm.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Repository
public class Manage implements Serializable {

//    主键id
    private Integer id;
//    用户名
    private String userName;
//    密码
    private String passWord;
    //姓名
    private String realName;



}
