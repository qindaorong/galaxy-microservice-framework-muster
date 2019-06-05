package com.galaxy.microservice.order.core.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tbl_order")
public class Order {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;


}