package com.galaxy.microservice.order.api.remote;

import com.galaxy.microservice.order.api.vo.OrderVo;
import com.galaxy.microservice.util.entity.ResponseResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface OrderServiceFacade {
    @GetMapping("order/getOrder/{id}")
    ResponseResult<OrderVo> getOrder(@PathVariable("id") Integer id);
}
