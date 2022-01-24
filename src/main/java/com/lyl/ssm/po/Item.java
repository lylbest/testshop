package com.lyl.ssm.po;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Item implements Serializable {

    /**
     * 主键
     */
    private Integer id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品价格
     */
    private String price;

    /**
     * 收藏数量
     */
    private Integer scNum;

    /**
     * 购买数量
     */
    private Integer gmNum;

    /**
     * 主图
     */
    private String url1;
    /**
     * 副图1
     */
    private String url2;
    /**
     * 副图2
     */
    private String url3;
    /**
     * 副图3
     */
    private String url4;
    /**
     * 副图4
     */
    private String url5;

    /**
     * 描述
     */
    private String ms;
    private String pam1;
    private String pam2;
    private String pam3;
    private String val3;
    private String val2;
    private String val1;
    private int type;

    /**
     * 折扣
     */
    private Integer zk;

    /**
     * 类别一级
     */
    private Integer categoryIdOne;
    private ItemCategory yiji;

    /**
     * 类别二级
     */
    private Integer categoryIdTwo;
    private ItemCategory erji;
    /**
     * 是否删除:0有效，1已删除
     *
     */
    private Integer isDelete;













}
