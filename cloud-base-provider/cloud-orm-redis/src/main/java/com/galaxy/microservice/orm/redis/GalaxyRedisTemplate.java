package com.galaxy.microservice.orm.redis;

import com.galaxy.microservice.orm.redis.operations.value.ValueOperations;
import com.galaxy.microservice.orm.redis.operations.value.impl.ValueOperationsImpl;
import com.galaxy.microservice.orm.redis.operations.list.ListOperations;
import com.galaxy.microservice.orm.redis.operations.list.impl.ListOperationsImpl;
import com.galaxy.microservice.orm.redis.operations.map.MapOperations;
import com.galaxy.microservice.orm.redis.operations.map.impl.MapOperationsImpl;
import com.galaxy.microservice.orm.redis.operations.set.SetOperations;
import com.galaxy.microservice.orm.redis.operations.set.impl.SetOperationsImpl;
import com.galaxy.microservice.orm.redis.operations.zset.ZSetOperations;
import com.galaxy.microservice.orm.redis.operations.zset.impl.ZSetOperationsImpl;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @ClassName： GalaxyRedisTemplate
 * @Description
 * @Author alan qin
 * @Date 2019-04-12
 **/
@Component
@Getter
@Slf4j
public class GalaxyRedisTemplate extends BaseRedis {

    @Autowired(required = false)
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        super.init(redisTemplate);
    }

    @PostConstruct
    public void init(){
        listOperations = ListOperationsImpl.getInstance(redisTemplate);
        setOperations = SetOperationsImpl.getInstance(redisTemplate);
        zSetOperations = ZSetOperationsImpl.getInstance(redisTemplate);
        mapOperations = MapOperationsImpl.getInstance(redisTemplate);
        valueOperations = ValueOperationsImpl.getInstance(redisTemplate);

        log.info("[GalaxyRedisTemplate] has bean init!");
    }

    private ListOperations listOperations;

    private SetOperations setOperations;

    private ZSetOperations zSetOperations;

    private MapOperations mapOperations;

    private ValueOperations valueOperations;


    public boolean hashKey(String key){
        return redisTemplate.hasKey(key);
    }

    public void deleteKey(String key){
        redisTemplate.delete(key);
    }
}
