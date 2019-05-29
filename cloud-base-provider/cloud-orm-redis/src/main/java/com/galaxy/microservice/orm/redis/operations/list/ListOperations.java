package com.galaxy.microservice.orm.redis.operations.list;

import java.util.Collection;
import java.util.List;

public interface ListOperations {

    /**
     * 指定list从左入栈
     *
     * @paramkey
     * @return当前队列的长度
     */
    public Long leftPush(String key, Object value) ;

    /**
     * 指定list从左出栈
     * 如果列表没有元素,会堵塞到列表一直有元素或者超时为止
     *
     * @paramkey
     * @return出栈的值
     */
    public Object leftPop(String key);

    /**
     * 从左边依次入栈
     * 导入顺序按照Collection顺序
     * 如:abc=>cba
     *
     * @return
     * @paramkey
     * @paramvalues
     */
    public Long leftPushAll(String key, Collection<Object> values) ;

    /**
     * 指定list从右入栈
     *
     * @paramkey
     * @return当前队列的长度
     */
    public Long rightPush(String key, Object value) ;

    /**
     * 指定list从右出栈
     * 如果列表没有元素,会堵塞到列表一直有元素或者超时为止
     *
     * @paramkey
     * @return出栈的值
     */
    public Object rightPop(String key) ;

    /**
     * 从右边依次入栈
     * 导入顺序按照Collection顺序
     * 如:abc=>abc
     *
     * @return
     * @paramkey
     * @paramvalues
     */
    public Long rightPushAll(String key, Collection<Object> values);


    /**
     * 根据下标获取值
     *
     * @return
     * @paramkey
     * @paramindex
     */
    public Object popIndex(String key, long index);


    /**
     * 获取列表指定长度
     *
     * @return
     * @paramkey
     * @paramindex
     */
    public Long listSize(String key, long index);


    /**
     * 获取列表指定范围内的所有值
     *
     * @return
     * @paramkey
     * @paramstart
     * @paramend
     */
    public List<Object> listRange(String key, long start, long end);


    /**
     * 删除key中值为value的count个数.
     *
     * @paramkey
     * @paramcount
     * @paramvalue
     * @return成功删除的个数
     */
    public Long listRemove(String key, long count, Object value);


    /**
     * 删除列表[start,end]以外的所有元素
     *
     * @paramkey
     * @paramstart
     * @paramend
     */
    public void listTrim(String key, long start, long end) ;

    /**
     * 将key右出栈,并左入栈到key2
     *
     * @paramkey右出栈的列表
     * @paramkey2左入栈的列表
     * @return操作的值
     */
    public Object rightPopAndLeftPush(String key, String key2);
}
