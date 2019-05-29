package com.galaxy.microservice.orm.redis.operations.value;

import java.util.Map;
import java.util.concurrent.TimeUnit;

public interface ValueOperations {

    /**
     * 获取String类型key-value
     *
     * @return
     * @paramkey
     */
    public Object getObject(String key);

    /**
     * 获取String类型key-value
     *
     * @return
     * @paramkey
     */
    public String get(String key) ;

    /**
     * 设置String类型key-value并添加过期时间(毫秒单位)
     *
     * @paramkey
     * @paramvalue
     * @paramtime过期时间,毫秒单位
     */
    public void setForTimeMS(String key, String value, long time) ;

    /**
     * 设置String类型key-value并添加过期时间(分钟单位)
     *
     * @paramkey
     * @paramvalue
     * @paramtime过期时间,分钟单位
     */
    public void setForTimeMIN(String key, Object value, long time);

    /**
     * 设置String类型key-value并添加过期时间(分钟单位)
     *
     * @paramkey
     * @paramvalue
     * @paramtime过期时间,分钟单位
     */
    public void setForTimeCustom(String key, String value, long time, TimeUnit type);

    /**
     * 如果key存在则覆盖,并返回旧值.
     * 如果不存在,返回null并添加
     *
     * @return
     * @paramkey
     * @paramvalue
     */
    public String getAndSet(String key, String value);

    /**
     * 批量添加key-value(重复的键会覆盖)
     *
     * @paramkeyAndValue
     */
    public void batchSet(Map<String, String> keyAndValue);


    /**
     * 批量添加key-value只有在键不存在时,才添加
     * map中只要有一个key存在,则全部不添加
     *
     * @paramkeyAndValue
     */
    public void batchSetIfAbsent(Map<String, String> keyAndValue);

    /**
     * 对一个key-value的值进行加减操作,
     * 如果该key不存在将创建一个key并赋值该number
     * 如果key存在,但value不是长整型,将报错
     *
     * @paramkey
     * @paramnumber
     */
    public Long increment(String key, long number);

    /**
     * 对一个key-value的值进行加减操作,
     * 如果该key不存在将创建一个key并赋值该number
     * 如果key存在,但value不是纯数字,将报错
     *
     * @paramkey
     * @paramnumber
     */
    public Double increment(String key, double number) ;

    /**
     * 给一个指定的key值附加过期时间
     *
     * @return
     * @paramkey
     * @paramtime
     * @paramtype
     */
    public boolean expire(String key, long time, TimeUnit type) ;

    /**
     * 移除指定key的过期时间
     *
     * @return
     * @paramkey
     */
    public boolean persist(String key);


    /**
     * 获取指定key的过期时间
     *
     * @return
     * @paramkey
     */
    public Long getExpire(String key) ;

    /**
     * 修改key
     *
     * @return
     * @paramkey
     */
    public void rename(String key, String newKey);

    /**
     * 删除key-value
     *
     * @return
     * @paramkey
     */
    public void delete(String key);

    /**
     * 设置String类型key-value
     *
     * @paramkey
     * @paramvalue
     */
    public void set(String key, String value);


    /** *
     *@描述   设置Bit偏移量
     *@参数  [key, offset, value]
     *@返回值  void
     *@创建人  alan qin
     *@创建时间  04/02/2019
     *@修改人和其它信息
     **/
    public void setBit(String key, long offset, boolean value);

    /** *
     *@描述   查询对应key在offset上的偏移量
     *@参数  [key, offset]
     *@返回值  java.lang.Boolean
     *@创建人  alan qin
     *@创建时间  04/02/2019
     *@修改人和其它信息
     **/
    public void getBit(String key, long offset);

}
