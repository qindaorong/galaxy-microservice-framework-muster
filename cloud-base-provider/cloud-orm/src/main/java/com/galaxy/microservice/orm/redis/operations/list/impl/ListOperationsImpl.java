package com.galaxy.microservice.orm.redis.operations.list.impl;

import com.galaxy.microservice.orm.redis.operations.list.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collection;
import java.util.List;

/**
 * @ClassName： ListOperationsImpl
 * @Description
 * @Author alan qin
 * @Date 2019-04-12
 **/
public class ListOperationsImpl implements ListOperations {


    static RedisTemplate redisTemplate;

    private ListOperationsImpl(){ }

    public static  final ListOperationsImpl getInstance(RedisTemplate redisTemplate){
        ListOperationsImpl.redisTemplate = redisTemplate;
        return LazyHolder.lazy;
    }
    private static  class LazyHolder{
        private static final ListOperationsImpl lazy=new ListOperationsImpl();
    }


    /**
     * 指定list从左入栈
     *
     * @paramkey
     * @return当前队列的长度
     */
    @Override
    public Long leftPush(String key, Object value) {
        return redisTemplate.opsForList().leftPush(key, value);
    }

    /**
     * 指定list从左出栈
     * 如果列表没有元素,会堵塞到列表一直有元素或者超时为止
     *
     * @paramkey
     * @return出栈的值
     */
    @Override
    public Object leftPop(String key) {
        return redisTemplate.opsForList().leftPop(key);
    }

    /**
     * 从左边依次入栈
     * 导入顺序按照Collection顺序
     * 如:abc=>cba
     *
     * @return
     * @paramkey
     * @paramvalues
     */
    @Override
    public Long leftPushAll(String key, Collection<Object> values) {
        return redisTemplate.opsForList().leftPushAll(key, values);
    }

    /**
     * 指定list从右入栈
     *
     * @paramkey
     * @return当前队列的长度
     */
    @Override
    public Long rightPush(String key, Object value) {
        return redisTemplate.opsForList().rightPush(key, value);
    }

    /**
     * 指定list从右出栈
     * 如果列表没有元素,会堵塞到列表一直有元素或者超时为止
     *
     * @paramkey
     * @return出栈的值
     */
    @Override
    public Object rightPop(String key) {
        return redisTemplate.opsForList().rightPop(key);
    }

    /**
     * 从右边依次入栈
     * 导入顺序按照Collection顺序
     * 如:abc=>abc
     *
     * @return
     * @paramkey
     * @paramvalues
     */
    @Override
    public Long rightPushAll(String key, Collection<Object> values) {
        return redisTemplate.opsForList().rightPushAll(key, values);
    }


    /**
     * 根据下标获取值
     *
     * @return
     * @paramkey
     * @paramindex
     */
    @Override
    public Object popIndex(String key, long index) {
        return redisTemplate.opsForList().index(key, index);
    }


    /**
     * 获取列表指定长度
     *
     * @return
     * @paramkey
     * @paramindex
     */
    @Override
    public Long listSize(String key, long index) {
        return redisTemplate.opsForList().size(key);
    }


    /**
     * 获取列表指定范围内的所有值
     *
     * @return
     * @paramkey
     * @paramstart
     * @paramend
     */
    @Override
    public List<Object> listRange(String key, long start, long end) {
        return redisTemplate.opsForList().range(key, start, end);
    }


    /**
     * 删除key中值为value的count个数.
     *
     * @paramkey
     * @paramcount
     * @paramvalue
     * @return成功删除的个数
     */
    @Override
    public Long listRemove(String key, long count, Object value) {
        return redisTemplate.opsForList().remove(key, count, value);
    }


    /**
     * 删除列表[start,end]以外的所有元素
     *
     * @paramkey
     * @paramstart
     * @paramend
     */
    @Override
    public void listTrim(String key, long start, long end) {
        redisTemplate.opsForList().trim(key, start, end);

    }

    /**
     * 将key右出栈,并左入栈到key2
     *
     * @paramkey右出栈的列表
     * @paramkey2左入栈的列表
     * @return操作的值
     */
    @Override
    public Object rightPopAndLeftPush(String key, String key2) {
        return redisTemplate.opsForList().rightPopAndLeftPush(key, key2);

    }
}
