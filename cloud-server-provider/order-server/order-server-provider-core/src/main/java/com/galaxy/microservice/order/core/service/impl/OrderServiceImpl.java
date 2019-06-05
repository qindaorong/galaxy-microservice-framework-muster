package com.galaxy.microservice.order.core.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.galaxy.microservice.order.api.vo.OrderVo;
import com.galaxy.microservice.order.core.entity.Order;
import com.galaxy.microservice.order.core.mapper.OrderMapper;
import com.galaxy.microservice.order.core.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    @Autowired
    private OrderMapper rderMapper;

    @Override
    public OrderVo getOrder(Integer id) {
        OrderVo vo  = new OrderVo();
        vo.setId(1);
        vo.setName("order 1");
        return vo;
    }
}
