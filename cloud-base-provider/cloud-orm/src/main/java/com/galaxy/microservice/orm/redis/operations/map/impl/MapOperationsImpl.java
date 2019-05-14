package com.galaxy.microservice.orm.redis.operations.map.impl;

import com.galaxy.microservice.orm.redis.operations.map.MapOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName： MapOperationsImpl
 * @Description
 * @Author alan qin
 * @Date 2019-04-12
 **/
public class MapOperationsImpl implements MapOperations {

    static RedisTemplate redisTemplate;

    private MapOperationsImpl(){ }

    public static  final MapOperationsImpl getInstance(RedisTemplate redisTemplate){
        MapOperationsImpl.redisTemplate = redisTemplate;
        return MapOperationsImpl.LazyHolder.lazy;
    }
    private static  class LazyHolder{
        private static final MapOperationsImpl lazy=new MapOperationsImpl();
    }

    /**
     * 向redis中添加一个Map
     * @param key
     * @param map
     */
    @Override
    public void putALL(String key, Map<String,Object> map){
        redisTemplate.opsForHash().putAll(key,map);
    }


    /**
     * 获取key下的所有hashkey和value
     *
     * @return
     * @paramkey
     */
    @Override
    public Map<String,Object> getHashEntries(String key) {
        return redisTemplate.opsForHash().entries(key);
    }

    /**
     * 获取key下的所有hash key
     *
     * @return
     * @paramkey
     */
    @Override
    public Set<String> getHashEntriesKeys(String key) {
        return redisTemplate.opsForHash().keys(key);
    }

    /**
     * 获取key下的所有hash Values
     *
     * @return
     * @paramkey
     */
    @Override
    public List<Object> getHashEntriesValues(String key) {
        return redisTemplate.opsForHash().values(key);
    }


    /**
     * 获取key-map下对应mapKey的value值
     * @param key
     * @param mapKey
     * @return
     */
    @Override
    public Object getHashEntriesBykey(String key,String mapKey) {
        return redisTemplate.opsForHash().get(key,mapKey);
    }

}
