package com.galaxy.microservice.user.api.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2018-05-10
 * Time: 21:03
 */
@Data
public class RoleVo implements Serializable {
    private static final long serialVersionUID = 2179037393108205286L;

    private long id;

    private String name;

    private String value;

    private String tips;

    private Date createTime;

    private Date updateTime;

    private Integer status;
}
