package com.galaxy.microservice.orm.redis.operations.zset;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface ZSetOperations {

    /**
     * 添加ZSet元素
     *
     * @paramkey
     * @paramvalue
     * @paramscore
     */
    public boolean add(String key, Object value, double score);

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
    public Long batchAddZset(String key, Set<org.springframework.data.redis.core.ZSetOperations.TypedTuple<Object>> tuples);

    /**
     * Zset删除一个或多个元素
     *
     * @return
     * @paramkey
     * @paramvalues
     */
    public Long removeZset(String key, String... values);

    /**
     * 对指定的zset的value值,socre属性做增减操作
     *
     * @return
     * @paramkey
     * @paramvalue
     * @paramscore
     */
    public Double incrementScore(String key, Object value, double score);

    /**
     * 获取key中指定value的排名(从0开始,从小到大排序)
     *
     * @return
     * @paramkey
     * @paramvalue
     */
    public Long rank(String key, Object value);

    /**
     * 获取key中指定value的排名(从0开始,从大到小排序)
     *
     * @return
     * @paramkey
     * @paramvalue
     */
    Long reverseRank(String key, Object value);

    /**
     * 获取索引区间内的排序结果集合(从0开始,从小到大,带上分数)
     *
     * @return
     * @paramkey
     * @paramstart
     * @paramend
     */
    Set<org.springframework.data.redis.core.ZSetOperations.TypedTuple<Object>> rangeWithScores(String key, long start, long end);

    /**
     * 获取索引区间内的排序结果集合(从0开始,从小到大,只有列名)
     *
     * @return
     * @paramkey
     * @paramstart
     * @paramend
     */
    Set<Object> range(String key, long start, long end);

    /**
     * 获取分数范围内的[min,max]的排序结果集合(从小到大,只有列名)
     *
     * @return
     * @paramkey
     * @parammin
     * @parammax
     */
    Set<Object> rangeByScore(String key, double min, double max);

    /**
     * 获取分数范围内的[min,max]的排序结果集合(从小到大,集合带分数)
     *
     * @return
     * @paramkey
     * @parammin
     * @parammax
     */
    Set<org.springframework.data.redis.core.ZSetOperations.TypedTuple<Object>> rangeByScoreWithScores(String key, double min, double max);

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
    Set<Object> rangeByScore(String key, double min, double max, long offset, long count);

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
    Set<org.springframework.data.redis.core.ZSetOperations.TypedTuple<Object>> rangeByScoreWithScores(String key, double min, double max, long offset, long count);

    /**
     * 获取索引区间内的排序结果集合(从0开始,从大到小,只有列名)
     *
     * @return
     * @paramkey
     * @paramstart
     * @paramend
     */
    Set<Object> reverseRange(String key, long start, long end);

    /**
     * 获取索引区间内的排序结果集合(从0开始,从大到小,带上分数)
     *
     * @return
     * @paramkey
     * @paramstart
     * @paramend
     */
    Set<org.springframework.data.redis.core.ZSetOperations.TypedTuple<Object>> reverseRangeWithScores(String key, long start, long end);

    /**
     * 获取分数范围内的[min,max]的排序结果集合(从大到小,集合不带分数)
     *
     * @return
     * @paramkey
     * @parammin
     * @parammax
     */
    Set<Object> reverseRangeByScore(String key, double min, double max);

    /**
     * 获取分数范围内的[min,max]的排序结果集合(从大到小,集合带分数)
     *
     * @return
     * @paramkey
     * @parammin
     * @parammax
     */
    Set<org.springframework.data.redis.core.ZSetOperations.TypedTuple<Object>> reverseRangeByScoreWithScores(String key, double min, double max);

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
    Set<Object> reverseRangeByScore(String key, double min, double max, long offset, long count);

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
    Set<org.springframework.data.redis.core.ZSetOperations.TypedTuple<Object>> reverseRangeByScoreWithScores(String key, double min, double max, long offset, long count);

    /**
     * 返回指定分数区间[min,max]的元素个数
     *
     * @return
     * @paramkey
     * @parammin
     * @parammax
     */
    long countZSet(String key, double min, double max);

    /**
     * 返回zset集合数量
     *
     * @return
     * @paramkey
     */
    long sizeZset(String key);

    /**
     * 获取指定成员的score值
     *
     * @return
     * @paramkey
     * @paramvalue
     */
    Double score(String key, Object value);

    /**
     * 删除指定索引位置的成员,其中成员分数按(从小到大)
     *
     * @return
     * @paramkey
     * @paramstart
     * @paramend
     */
    Long removeRange(String key, long start, long end);

    /**
     * 删除指定分数范围内的成员[main,max],其中成员分数按(从小到大)
     *
     * @return
     * @paramkey
     * @parammin
     * @parammax
     */
    Long removeRangeByScore(String key, double min, double max);

    /**
     * key和other两个集合的并集,保存在destKey集合中,列名相同的score相加
     *
     * @return
     * @paramkey
     * @paramotherKey
     * @paramdestKey
     */
    Long unionAndStoreZset(String key, String otherKey, String destKey);

    /**
     * key和otherKeys多个集合的并集,保存在destKey集合中,列名相同的score相加
     *
     * @return
     * @paramkey
     * @paramotherKeys
     * @paramdestKey
     */
    Long unionAndStoreZset(String key, Collection<String> otherKeys, String destKey);

    /**
     * key和otherKey两个集合的交集,保存在destKey集合中
     *
     * @return
     * @paramkey
     * @paramotherKey
     * @paramdestKey
     */
    Long intersectAndStore(String key, String otherKey, String destKey);

    /**
     * key和otherKeys多个集合的交集,保存在destKey集合中
     *
     * @return
     * @paramkey
     * @paramotherKeys
     * @paramdestKey
     */
    Long intersectAndStore(String key, Collection<String> otherKeys, String destKey);

    /**
     * 向redis中添加一个Map
     * @param key
     * @param map
     */
    public void putALL(String key, Map<String,Object> map);


    /**
     * 获取key下的所有hashkey和value
     *
     * @return
     * @paramkey
     */
    public Map<String,Object> getHashEntries(String key);

    /**
     * 获取key下的所有hash key
     *
     * @return
     * @paramkey
     */
    public Set<String> getHashEntriesKeys(String key) ;

    /**
     * 获取key下的所有hash Values
     *
     * @return
     * @paramkey
     */
    public List<Object> getHashEntriesValues(String key);


    /**
     * 获取key-map下对应mapKey的value值
     * @param key
     * @param mapKey
     * @return
     */
    public Object getHashEntriesBykey(String key,String mapKey) ;
}
