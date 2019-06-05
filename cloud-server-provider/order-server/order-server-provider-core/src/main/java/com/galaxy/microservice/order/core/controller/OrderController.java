package com.galaxy.microservice.order.core.controller;

import com.galaxy.microservice.order.api.remote.OrderServiceFacade;
import com.galaxy.microservice.order.api.vo.OrderVo;
import com.galaxy.microservice.order.core.service.OrderService;
import com.galaxy.microservice.util.entity.ResponseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController implements OrderServiceFacade {
    @Autowired
    private OrderService orderService;

    @Override
    @GetMapping("/getOrder/{roleId}")
    public ResponseResult<OrderVo> getOrder(@PathVariable("id") Integer id){
        OrderVo vo = orderService.getOrder(id);
        return ResponseResult.success(vo);
    }

}
