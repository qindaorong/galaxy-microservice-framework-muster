package com.galaxy.microservice.orm.redis.operations.set.impl;

import com.galaxy.microservice.orm.redis.operations.set.SetOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * @ClassName： SetOperationsImpl
 * @Description
 * @Author alan qin
 * @Date 2019-04-12
 **/
public class SetOperationsImpl implements SetOperations {


    static RedisTemplate redisTemplate;

    private SetOperationsImpl(){ }

    public static  final SetOperationsImpl getInstance(RedisTemplate redisTemplate){
        SetOperationsImpl.redisTemplate = redisTemplate;
        return SetOperationsImpl.LazyHolder.lazy;
    }
    private static  class LazyHolder{
        private static final SetOperationsImpl lazy=new SetOperationsImpl();
    }

    /**
     * 添加set元素
     *
     * @return
     * @paramkey
     * @paramvalues
     */
    @Override
    public Long add(String key, String... values) {
        return redisTemplate.opsForSet().add(key, values);
    }

    /**
     * 获取两个集合的差集
     *
     * @return
     * @paramkey
     * @paramkey2
     */
    @Override
    public Set<Object> difference(String key, String otherkey) {
        return redisTemplate.opsForSet().difference(key, otherkey);
    }


    /**
     * 获取key和集合collections中的key集合的差集
     *
     * @return
     * @paramkey
     * @paramcollections
     */
    @Override
    public Set<Object> difference(String key, Collection<Object> otherKeys) {
        return redisTemplate.opsForSet().difference(key, otherKeys);
    }

    /**
     * 将key与otherkey的差集,添加到新的newKey集合中
     *
     * @paramkey
     * @paramotherkey
     * @paramnewKey
     * @return返回差集的数量
     */
    @Override
    public Long differenceAndStore(String key, String otherkey, String newKey) {
        return redisTemplate.opsForSet().differenceAndStore(key, otherkey, newKey);
    }

    /**
     * 将key和集合collections中的key集合的差集添加到newkey集合中
     *
     * @paramkey
     * @paramotherKeys
     * @paramnewKey
     * @return返回差集的数量
     */
    @Override
    public Long differenceAndStore(String key, Collection<Object> otherKeys, String newKey) {
        return redisTemplate.opsForSet().differenceAndStore(newKey, otherKeys, newKey);
    }

    /**
     * 删除一个或多个集合中的指定值
     *
     * @paramkey
     * @paramvalues
     * @return成功删除数量
     */
    @Override
    public Long remove(String key, Object... values) {
        return redisTemplate.opsForSet().remove(key, values);
    }

    /**
     * 删除一个集合中的所有KEY 对应value
     * @param keys
     */
    @Override
    public void remove(Collection  keys) {
        redisTemplate.delete(keys);
    }

    /**
     * 随机移除一个元素,并返回出来
     *
     * @return
     * @paramkey
     */
    @Override
    public Object randomSetPop(String key) {
        return redisTemplate.opsForSet().pop(key);
    }

    /**
     * 随机获取一个元素
     *
     * @return
     * @paramkey
     */
    @Override
    public Object randomSet(String key) {
        return redisTemplate.opsForSet().randomMember(key);
    }

    /**
     * 随机获取指定数量的元素,同一个元素可能会选中两次
     *
     * @return
     * @paramkey
     * @paramcount
     */
    @Override
    public List<Object> randomSet(String key, long count) {
        return redisTemplate.opsForSet().randomMembers(key, count);
    }

    /**
     * 随机获取指定数量的元素,去重(同一个元素只能选择两一次)
     *
     * @return
     * @paramkey
     * @paramcount
     */
    @Override
    public Set<Object> randomSetDistinct(String key, long count) {
        return redisTemplate.opsForSet().distinctRandomMembers(key, count);
    }

    /**
     * 将key中的value转入到destKey中
     *
     * @paramkey
     * @paramvalue
     * @paramdestKey
     * @return返回成功与否
     */
    @Override
    public boolean moveSet(String key, Object value, String destKey) {
        return redisTemplate.opsForSet().move(key, value, destKey);
    }

    /**
     * 无序集合的大小
     *
     * @return
     * @paramkey
     */
    @Override
    public Long setSize(String key) {
        return redisTemplate.opsForSet().size(key);
    }

    /**
     * 判断set集合中是否有value
     *
     * @return
     * @paramkey
     * @paramvalue
     */
    @Override
    public boolean isMember(String key, Object value) {
        return redisTemplate.opsForSet().isMember(key, value);
    }

    /**
     * 返回key和othere的并集
     *
     * @return
     * @paramkey
     * @paramotherKey
     */
    @Override
    public Set<Object> unionSet(String key, String otherKey) {
        return redisTemplate.opsForSet().union(key, otherKey);
    }

    /**
     * 返回key和otherKeys的并集
     *
     * @return
     * @paramkey
     * @paramotherKeykey的集合
     */
    @Override
    public Set<Object> unionSet(String key, Collection<Object> otherKeys) {
        return redisTemplate.opsForSet().union(key, otherKeys);
    }

    /**
     * 将key与otherKey的并集,保存到destKey中
     *
     * @paramkey
     * @paramotherKey
     * @paramdestKey
     * @returndestKey数量
     */
    @Override
    public Long unionAndStoreSet(String key, String otherKey, String destKey) {
        return redisTemplate.opsForSet().unionAndStore(key, otherKey, destKey);
    }

    /**
     * 将key与otherKey的并集,保存到destKey中
     *
     * @paramkey
     * @paramotherKeys
     * @paramdestKey
     * @returndestKey数量
     */
    @Override
    public Long unionAndStoreSet(String key, Collection<Object> otherKeys, String destKey) {
        return redisTemplate.opsForSet().unionAndStore(key, otherKeys, destKey);
    }

    /**
     * 返回集合中所有元素
     *
     * @return
     * @paramkey
     */
    @Override
    public Set<Object> members(String key) {
        return redisTemplate.opsForSet().members(key);
    }

}
