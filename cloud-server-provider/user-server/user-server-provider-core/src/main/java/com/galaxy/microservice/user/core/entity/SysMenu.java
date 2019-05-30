package com.galaxy.microservice.user.core.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@EqualsAndHashCode(callSuper = true)
@TableName("sys_menu")
public class SysMenu {

    @TableId(type = IdType.AUTO)
    private Integer id;

    @TableField("code")
    private String code;

    /**
     * 菜单父编码
     */
    @TableField("p_code")
    private String pCode;

    /**
     * 父菜单ID
     */
    @TableField("p_id")
    private String pId;

    /**
     * 名称
     */
    @TableField("name")
    private String name;

    /**
     * 请求地址
     */
    @TableField("url")
    private String url;

    /**
     * 是否是菜单
     */
    @TableField("is_menu")
    private Integer isMenu;

    /**
     * 菜单层级
     */
    @TableField("level")
    private Integer level;

    /**
     * 菜单排序
     */
    @TableField("sort")
    private Integer sort;

    @TableField("status")
    private Integer status;

    @TableField("icon")
    private String icon;

    @TableField("create_time")
    private Date createTime;

    @TableField("update_time")
    private Date updateTime;

}