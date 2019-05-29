package com.galaxy.microservice.orm.redis.operations.value.impl;

import com.galaxy.microservice.orm.redis.operations.value.ValueOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName： ValueOperationsImpl
 * @Description
 * @Author alan qin
 * @Date 2019-04-12
 **/
public class ValueOperationsImpl implements ValueOperations {

    static RedisTemplate redisTemplate;


    private ValueOperationsImpl(){ }


    private static final String JEDIS = "jedis";

    public static  final ValueOperationsImpl getInstance(RedisTemplate redisTemplate){
        ValueOperationsImpl.redisTemplate = redisTemplate;
        return ValueOperationsImpl.LazyHolder.lazy;
    }
    private static  class LazyHolder{
        private static final ValueOperationsImpl lazy=new ValueOperationsImpl();
    }


    /**
     * 获取String类型key-value
     *
     * @return
     * @paramkey
     */
    @Override
    public Object getObject(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    /**
     * 获取String类型key-value
     *
     * @return
     * @paramkey
     */
    @Override
    public String get(String key) {
        return (String) redisTemplate.opsForValue().get(key);
    }

    /**
     * 设置String类型key-value并添加过期时间(毫秒单位)
     *
     * @paramkey
     * @paramvalue
     * @paramtime过期时间,毫秒单位
     */
    @Override
    public void setForTimeMS(String key, String value, long time) {
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.MILLISECONDS);
    }

    /**
     * 设置String类型key-value并添加过期时间(分钟单位)
     *
     * @paramkey
     * @paramvalue
     * @paramtime过期时间,分钟单位
     */
    @Override
    public void setForTimeMIN(String key, Object value, long time) {
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.MINUTES);
    }

    /**
     * 设置String类型key-value并添加过期时间(分钟单位)
     *
     * @paramkey
     * @paramvalue
     * @paramtime过期时间,分钟单位
     */
    @Override
    public void setForTimeCustom(String key, String value, long time, TimeUnit type) {
        redisTemplate.opsForValue().set(key, value, time, type);
    }

    /**
     * 如果key存在则覆盖,并返回旧值.
     * 如果不存在,返回null并添加
     *
     * @return
     * @paramkey
     * @paramvalue
     */
    @Override
    public String getAndSet(String key, String value) {
        return (String) redisTemplate.opsForValue().getAndSet(key, value);
    }

    /**
     * 批量添加key-value(重复的键会覆盖)
     *
     * @paramkeyAndValue
     */
    @Override
    public void batchSet(Map<String, String> keyAndValue) {
        redisTemplate.opsForValue().multiSet(keyAndValue);
    }


    /**
     * 批量添加key-value只有在键不存在时,才添加
     * map中只要有一个key存在,则全部不添加
     *
     * @paramkeyAndValue
     */
    @Override
    public void batchSetIfAbsent(Map<String, String> keyAndValue) {
        redisTemplate.opsForValue().multiSetIfAbsent(keyAndValue);
    }

    /**
     * 对一个key-value的值进行加减操作,
     * 如果该key不存在将创建一个key并赋值该number
     * 如果key存在,但value不是长整型,将报错
     *
     * @paramkey
     * @paramnumber
     */
    @Override
    public Long increment(String key, long number) {
        return redisTemplate.opsForValue().increment(key, number);
    }

    /**
     * 对一个key-value的值进行加减操作,
     * 如果该key不存在将创建一个key并赋值该number
     * 如果key存在,但value不是纯数字,将报错
     *
     * @paramkey
     * @paramnumber
     */
    @Override
    public Double increment(String key, double number) {
        return redisTemplate.opsForValue().increment(key, number);
    }

    /**
     * 给一个指定的key值附加过期时间
     *
     * @return
     * @paramkey
     * @paramtime
     * @paramtype
     */
    @Override
    public boolean expire(String key, long time, TimeUnit type) {
        return redisTemplate.boundValueOps(key).expire(time, type);
    }

    /**
     * 移除指定key的过期时间
     *
     * @return
     * @paramkey
     */
    @Override
    public boolean persist(String key) {
        return redisTemplate.boundValueOps(key).persist();
    }


    /**
     * 获取指定key的过期时间
     *
     * @return
     * @paramkey
     */
    @Override
    public Long getExpire(String key) {
        return redisTemplate.boundValueOps(key).getExpire();
    }

    /**
     * 修改key
     *
     * @return
     * @paramkey
     */
    @Override
    public void rename(String key, String newKey) {
        redisTemplate.boundValueOps(key).rename(newKey);
    }

    /**
     * 删除key-value
     *
     * @return
     * @paramkey
     */
    @Override
    public void delete(String key) {
        redisTemplate.delete(key);
    }

    /**
     * 设置String类型key-value
     *
     * @paramkey
     * @paramvalue
     */
    @Override
    public void set(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }


    /** *
     *@描述   设置Bit偏移量
     *@参数  [key, offset, value]
     *@返回值  void
     *@创建人  alan qin
     *@创建时间  04/02/2019
     *@修改人和其它信息
     **/
    @Override
    public void setBit(String key, long offset, boolean value) {
        redisTemplate.opsForValue().setBit(key,offset,value);
    }

    /** *
     *@描述   查询对应key在offset上的偏移量
     *@参数  [key, offset]
     *@返回值  java.lang.Boolean
     *@创建人  alan qin
     *@创建时间  04/02/2019
     *@修改人和其它信息
     **/
    @Override
    public void getBit(String key, long offset) {
        redisTemplate.opsForValue().getBit(key,offset);
    }
}
