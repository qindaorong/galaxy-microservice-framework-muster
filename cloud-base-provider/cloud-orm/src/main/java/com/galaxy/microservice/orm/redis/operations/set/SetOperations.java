package com.galaxy.microservice.orm.redis.operations.set;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface SetOperations {

    /**
     * 添加set元素
     *
     * @return
     * @paramkey
     * @paramvalues
     */
    public Long add(String key, String... values) ;

    /**
     * 获取两个集合的差集
     *
     * @return
     * @paramkey
     * @paramkey2
     */
    public Set<Object> difference(String key, String otherkey);


    /**
     * 获取key和集合collections中的key集合的差集
     *
     * @return
     * @paramkey
     * @paramcollections
     */
    public Set<Object> difference(String key, Collection<Object> otherKeys);

    /**
     * 将key与otherkey的差集,添加到新的newKey集合中
     *
     * @paramkey
     * @paramotherkey
     * @paramnewKey
     * @return返回差集的数量
     */
    public Long differenceAndStore(String key, String otherkey, String newKey);

    /**
     * 将key和集合collections中的key集合的差集添加到newkey集合中
     *
     * @paramkey
     * @paramotherKeys
     * @paramnewKey
     * @return返回差集的数量
     */
    public Long differenceAndStore(String key, Collection<Object> otherKeys, String newKey);

    /**
     * 删除一个或多个集合中的指定值
     *
     * @paramkey
     * @paramvalues
     * @return成功删除数量
     */
    public Long remove(String key, Object... values);

    /**
     * 删除一个集合中的所有KEY 对应value
     * @param keys
     */
    public void remove(Collection  keys) ;

    /**
     * 随机移除一个元素,并返回出来
     *
     * @return
     * @paramkey
     */
    public Object randomSetPop(String key) ;

    /**
     * 随机获取一个元素
     *
     * @return
     * @paramkey
     */
    public Object randomSet(String key);

    /**
     * 随机获取指定数量的元素,同一个元素可能会选中两次
     *
     * @return
     * @paramkey
     * @paramcount
     */
    public List<Object> randomSet(String key, long count);

    /**
     * 随机获取指定数量的元素,去重(同一个元素只能选择两一次)
     *
     * @return
     * @paramkey
     * @paramcount
     */
    public Set<Object> randomSetDistinct(String key, long count);

    /**
     * 将key中的value转入到destKey中
     *
     * @paramkey
     * @paramvalue
     * @paramdestKey
     * @return返回成功与否
     */
    public boolean moveSet(String key, Object value, String destKey) ;

    /**
     * 无序集合的大小
     *
     * @return
     * @paramkey
     */
    public Long setSize(String key) ;

    /**
     * 判断set集合中是否有value
     *
     * @return
     * @paramkey
     * @paramvalue
     */
    public boolean isMember(String key, Object value);

    /**
     * 返回key和othere的并集
     *
     * @return
     * @paramkey
     * @paramotherKey
     */
    public Set<Object> unionSet(String key, String otherKey);

    /**
     * 返回key和otherKeys的并集
     *
     * @return
     * @paramkey
     * @paramotherKeykey的集合
     */
    public Set<Object> unionSet(String key, Collection<Object> otherKeys);

    /**
     * 将key与otherKey的并集,保存到destKey中
     *
     * @paramkey
     * @paramotherKey
     * @paramdestKey
     * @returndestKey数量
     */
    public Long unionAndStoreSet(String key, String otherKey, String destKey);

    /**
     * 将key与otherKey的并集,保存到destKey中
     *
     * @paramkey
     * @paramotherKeys
     * @paramdestKey
     * @returndestKey数量
     */
    public Long unionAndStoreSet(String key, Collection<Object> otherKeys, String destKey) ;

    /**
     * 返回集合中所有元素
     *
     * @return
     * @paramkey
     */
    public Set<Object> members(String key);
}
