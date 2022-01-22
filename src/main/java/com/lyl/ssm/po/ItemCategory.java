package com.lyl.ssm.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemCategory implements Serializable {



//    主键
    private Integer id;
//    名称
    private String name;
//    父id
    private Integer pid;
//    是否删除，0未删除，1删除
    private Integer isDelete;









}
