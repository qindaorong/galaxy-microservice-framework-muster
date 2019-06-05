package com.galaxy.microservice.order.core.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.galaxy.microservice.order.core.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}