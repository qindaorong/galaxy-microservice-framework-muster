package com.galaxy.microservice.orm.redis.operations.map;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface MapOperations {

    /**
     * 向redis中添加一个Map
     * @param key
     * @param map
     */
    public void putALL(String key, Map<String, Object> map);


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
    public Object getHashEntriesBykey(String key, String mapKey) ;
}
