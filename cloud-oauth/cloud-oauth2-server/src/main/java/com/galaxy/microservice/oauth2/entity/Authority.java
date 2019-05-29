package com.galaxy.microservice.oauth2.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@TableName("authority")
public class Authority {


    @TableId(type = IdType.AUTO)
    private long id;

    @TableField("name")
    private String name;
}
