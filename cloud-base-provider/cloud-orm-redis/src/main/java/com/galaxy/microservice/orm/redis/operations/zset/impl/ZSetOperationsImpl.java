package com.galaxy.microservice.orm.redis.operations.zset.impl;

import com.galaxy.microservice.orm.redis.operations.zset.ZSetOperations;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName： MapOperationsImpl
 * @Description
 * @Author alan qin
 * @Date 2019-04-12
 **/
public class ZSetOperationsImpl implements ZSetOperations {

    static RedisTemplate redisTemplate;

    private ZSetOperationsImpl(){ }

    public static  final ZSetOperationsImpl getInstance(RedisTemplate redisTemplate){
        ZSetOperationsImpl.redisTemplate = redisTemplate;
        return ZSetOperationsImpl.LazyHolder.lazy;
    }
    private static  class LazyHolder{
        private static final ZSetOperationsImpl lazy=new ZSetOperationsImpl();
    }


    /**
     * 添加ZSet元素
     *
     * @paramkey
     * @paramvalue
     * @paramscore
     */
    @Override
    public boolean add(String key, Object value, double score) {
        return redisTemplate.opsForZSet().add(key, value, score);
    }

    /**
     * 批量添加Zset<br>
     * Set<TypedTuple<Object>>tuples=newHashSet<>();<br>
     * TypedTuple<Object>objectTypedTuple1=newDefaultTypedTuple<Object>("zset-5",9.6);<br>
     * tuples.add(objectTypedTuple1);
     *
     * @return
     * @paramkey
     * @paramtuples
     */
    @Override
    public Long batchAddZset(String key, Set<org.springframework.data.redis.core.ZSetOperations.TypedTuple<Object>> tuples) {
        return redisTemplate.opsForZSet().add(key, tuples);
    }

    /**
     * Zset删除一个或多个元素
     *
     * @return
     * @paramkey
     * @paramvalues
     */
    @Override
    public Long removeZset(String key, String... values) {
        return redisTemplate.opsForZSet().remove(key, values);
    }

    /**
     * 对指定的zset的value值,socre属性做增减操作
     *
     * @return
     * @paramkey
     * @paramvalue
     * @paramscore
     */
    @Override
    public Double incrementScore(String key, Object value, double score) {
        return redisTemplate.opsForZSet().incrementScore(key, value, score);
    }

    /**
     * 获取key中指定value的排名(从0开始,从小到大排序)
     *
     * @return
     * @paramkey
     * @paramvalue
     */
    @Override
    public Long rank(String key, Object value) {
        return redisTemplate.opsForZSet().rank(key, value);
    }

    /**
     * 获取key中指定value的排名(从0开始,从大到小排序)
     *
     * @return
     * @paramkey
     * @paramvalue
     */
    @Override
    public Long reverseRank(String key, Object value) {
        return redisTemplate.opsForZSet().reverseRank(key, value);
    }

    /**
     * 获取索引区间内的排序结果集合(从0开始,从小到大,带上分数)
     *
     * @return
     * @paramkey
     * @paramstart
     * @paramend
     */
    @Override
    public Set<org.springframework.data.redis.core.ZSetOperations.TypedTuple<Object>> rangeWithScores(String key, long start, long end) {
        return redisTemplate.opsForZSet().rangeWithScores(key, start, end);
    }

    /**
     * 获取索引区间内的排序结果集合(从0开始,从小到大,只有列名)
     *
     * @return
     * @paramkey
     * @paramstart
     * @paramend
     */
    @Override
    public Set<Object> range(String key, long start, long end) {
        return redisTemplate.opsForZSet().range(key, start, end);
    }

    /**
     * 获取分数范围内的[min,max]的排序结果集合(从小到大,只有列名)
     *
     * @return
     * @paramkey
     * @parammin
     * @parammax
     */
    @Override
    public Set<Object> rangeByScore(String key, double min, double max) {
        return redisTemplate.opsForZSet().rangeByScore(key, min, max);
    }

    /**
     * 获取分数范围内的[min,max]的排序结果集合(从小到大,集合带分数)
     *
     * @return
     * @paramkey
     * @parammin
     * @parammax
     */
    @Override
    public Set<org.springframework.data.redis.core.ZSetOperations.TypedTuple<Object>> rangeByScoreWithScores(String key, double min, double max) {
        return redisTemplate.opsForZSet().rangeByScoreWithScores(key, min, max);
    }

    /**
     * 返回分数范围内指定count数量的元素集合,并且从offset下标开始(从小到大,不带分数的集合)
     *
     * @return
     * @paramkey
     * @parammin
     * @parammax
     * @paramoffset从指定下标开始
     * @paramcount输出指定元素数量
     */
    @Override
    public Set<Object> rangeByScore(String key, double min, double max, long offset, long count) {
        return redisTemplate.opsForZSet().rangeByScore(key, min, max, offset, count);
    }

    /**
     * 返回分数范围内指定count数量的元素集合,并且从offset下标开始(从小到大,带分数的集合)
     *
     * @return
     * @paramkey
     * @parammin
     * @parammax
     * @paramoffset从指定下标开始
     * @paramcount输出指定元素数量
     */
    @Override
    public Set<org.springframework.data.redis.core.ZSetOperations.TypedTuple<Object>> rangeByScoreWithScores(String key, double min, double max, long offset, long count) {
        return redisTemplate.opsForZSet().rangeByScoreWithScores(key, min, max, offset, count);
    }

    /**
     * 获取索引区间内的排序结果集合(从0开始,从大到小,只有列名)
     *
     * @return
     * @paramkey
     * @paramstart
     * @paramend
     */
    @Override
    public Set<Object> reverseRange(String key, long start, long end) {
        return redisTemplate.opsForZSet().reverseRange(key, start, end);
    }

    /**
     * 获取索引区间内的排序结果集合(从0开始,从大到小,带上分数)
     *
     * @return
     * @paramkey
     * @paramstart
     * @paramend
     */
    @Override
    public Set<org.springframework.data.redis.core.ZSetOperations.TypedTuple<Object>> reverseRangeWithScores(String key, long start, long end) {
        return redisTemplate.opsForZSet().reverseRangeWithScores(key, start, end);
    }

    /**
     * 获取分数范围内的[min,max]的排序结果集合(从大到小,集合不带分数)
     *
     * @return
     * @paramkey
     * @parammin
     * @parammax
     */
    @Override
    public Set<Object> reverseRangeByScore(String key, double min, double max) {
        return redisTemplate.opsForZSet().reverseRangeByScore(key, min, max);
    }

    /**
     * 获取分数范围内的[min,max]的排序结果集合(从大到小,集合带分数)
     *
     * @return
     * @paramkey
     * @parammin
     * @parammax
     */
    @Override
    public Set<org.springframework.data.redis.core.ZSetOperations.TypedTuple<Object>> reverseRangeByScoreWithScores(String key, double min, double max) {
        return redisTemplate.opsForZSet().reverseRangeByScoreWithScores(key, min, max);
    }

    /**
     * 返回分数范围内指定count数量的元素集合,并且从offset下标开始(从大到小,不带分数的集合)
     *
     * @return
     * @paramkey
     * @parammin
     * @parammax
     * @paramoffset从指定下标开始
     * @paramcount输出指定元素数量
     */
    @Override
    public Set<Object> reverseRangeByScore(String key, double min, double max, long offset, long count) {
        return redisTemplate.opsForZSet().reverseRangeByScore(key, min, max, offset, count);
    }

    /**
     * 返回分数范围内指定count数量的元素集合,并且从offset下标开始(从大到小,带分数的集合)
     *
     * @return
     * @paramkey
     * @parammin
     * @parammax
     * @paramoffset从指定下标开始
     * @paramcount输出指定元素数量
     */
    @Override
    public Set<org.springframework.data.redis.core.ZSetOperations.TypedTuple<Object>> reverseRangeByScoreWithScores(String key, double min, double max, long offset, long count) {
        return redisTemplate.opsForZSet().reverseRangeByScoreWithScores(key, min, max, offset, count);
    }

    /**
     * 返回指定分数区间[min,max]的元素个数
     *
     * @return
     * @paramkey
     * @parammin
     * @parammax
     */
    @Override
    public long countZSet(String key, double min, double max) {
        return redisTemplate.opsForZSet().count(key, min, max);
    }

    /**
     * 返回zset集合数量
     *
     * @return
     * @paramkey
     */
    @Override
    public long sizeZset(String key) {
        return redisTemplate.opsForZSet().size(key);
    }

    /**
     * 获取指定成员的score值
     *
     * @return
     * @paramkey
     * @paramvalue
     */
    @Override
    public Double score(String key, Object value) {
        return redisTemplate.opsForZSet().score(key, value);
    }

    /**
     * 删除指定索引位置的成员,其中成员分数按(从小到大)
     *
     * @return
     * @paramkey
     * @paramstart
     * @paramend
     */
    @Override
    public Long removeRange(String key, long start, long end) {
        return redisTemplate.opsForZSet().removeRange(key, start, end);
    }

    /**
     * 删除指定分数范围内的成员[main,max],其中成员分数按(从小到大)
     *
     * @return
     * @paramkey
     * @parammin
     * @parammax
     */
    @Override
    public Long removeRangeByScore(String key, double min, double max) {
        return redisTemplate.opsForZSet().removeRangeByScore(key, min, max);
    }

    /**
     * key和other两个集合的并集,保存在destKey集合中,列名相同的score相加
     *
     * @return
     * @paramkey
     * @paramotherKey
     * @paramdestKey
     */
    @Override
    public Long unionAndStoreZset(String key, String otherKey, String destKey) {
        return redisTemplate.opsForZSet().unionAndStore(key, otherKey, destKey);
    }

    /**
     * key和otherKeys多个集合的并集,保存在destKey集合中,列名相同的score相加
     *
     * @return
     * @paramkey
     * @paramotherKeys
     * @paramdestKey
     */
    @Override
    public Long unionAndStoreZset(String key, Collection<String> otherKeys, String destKey) {
        return redisTemplate.opsForZSet().unionAndStore(key, otherKeys, destKey);
    }

    /**
     * key和otherKey两个集合的交集,保存在destKey集合中
     *
     * @return
     * @paramkey
     * @paramotherKey
     * @paramdestKey
     */
    @Override
    public Long intersectAndStore(String key, String otherKey, String destKey) {
        return redisTemplate.opsForZSet().intersectAndStore(key, otherKey, destKey);
    }

    /**
     * key和otherKeys多个集合的交集,保存在destKey集合中
     *
     * @return
     * @paramkey
     * @paramotherKeys
     * @paramdestKey
     */
    @Override
    public Long intersectAndStore(String key, Collection<String> otherKeys, String destKey) {
        return redisTemplate.opsForZSet().intersectAndStore(key, otherKeys, destKey);
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
