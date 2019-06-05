package com.galaxy.microservice.order.core.service;

import com.galaxy.microservice.order.api.vo.OrderVo;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * User: Mr.Yangxiufeng
 * Date: 2018-06-13
 * Time: 10:12
 */
public interface OrderService {
    OrderVo getOrder(Integer id);
}
