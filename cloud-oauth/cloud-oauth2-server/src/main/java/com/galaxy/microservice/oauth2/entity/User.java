package com.galaxy.microservice.oauth2.entity;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@TableName("user")
public class User{

    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 登录密码
	 */
    @TableField("password")
    private String password;

	/**
	 * 用户名
	 */
	@TableField("username")
	private String username;

	/**
	 * 管理密码
	 */
	@TableField("admin_password")
	private String adminPassword;
	/**
	 * 邮箱
	 */
    @TableField("email")
    private String email;
	/**
	 * 手机号
	 */
	@TableField("mobile")
	private String mobile;
	/**
	 * 是否激活
	 */
    @TableField("activated")
    private boolean isActivated;
	/**
	 * 是否是主账号
	 */
    @TableField("primary_user")
    private boolean isPrimaryUser;
	/**
	 * sac签名
	 */
    @TableField("lab")
    private String lab;
	/**
	 * facebook标识
	 */
	@TableField("facebook_logo")
	private String facebookLogo;
	/**
	 * google标识
	 */
	@TableField("google_logo")
	private String googleLogo;
	/**
	 * 支付时间
	 */
	@TableField("pay_time")
	private Long payTime;
	/**
	 * 到期时间
	 */
	@TableField("out_time")
	private Long outTime;
	/**
	 * 账单id
	 */
	@TableField("bill_id")
	private Long billId;
	/**
	 * 余量id
	 */
	@TableField("combo_margin_id")
	private Long comboMarginId;

	/**
	 * 创建时间
	 * 数据保存时会自动填充
	 */
	@TableField(value = "create_time" , fill = FieldFill.INSERT)
	protected Long createTime;

	/**
	 * 更新时间
	 * 数据保存或更新时会自动填充
	 */
	@TableField(value = "update_time" , fill = FieldFill.INSERT_UPDATE)
	protected Long updateTime;

	/**
	 * 逻辑删除标识
	 * 框架自动处理
	 */
	@TableField(value = "delete_flag")
	@TableLogic
	protected Integer deleteFlag;



}

