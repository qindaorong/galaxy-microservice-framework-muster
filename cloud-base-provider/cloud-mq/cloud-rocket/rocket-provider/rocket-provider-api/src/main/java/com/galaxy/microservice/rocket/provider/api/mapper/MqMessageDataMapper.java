package com.galaxy.microservice.rocket.provider.api.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.galaxy.microservice.rocket.provider.api.entity.MqMessageData;
import com.galaxy.microservice.rocket.provider.api.model.dto.MessageQueryDto;
import com.galaxy.microservice.rocket.provider.api.model.vo.MqMessageVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MqMessageDataMapper extends BaseMapper<MqMessageData> {

    /**
     * 获取7天前消息总数.
     *
     * @param shardingTotalCount the sharding total count
     * @param shardingItem       the sharding item
     * @param messageType        the message type
     *
     * @return the delete total count
     */
    int getBefore7DayTotalCount(@Param("shardingTotalCount") int shardingTotalCount, @Param("shardingItem") int shardingItem, @Param("messageType") int messageType);

    /**
     * Gets id list before 7 day.
     *
     * @param shardingTotalCount the sharding total count
     * @param shardingItem       the sharding item
     * @param messageType        the message type
     * @param currentPage        the current page
     * @param pageSize           the page size
     *
     * @return the id list before 7 day
     */
    List<Long> getIdListBefore7Day(@Param("shardingTotalCount") int shardingTotalCount, @Param("shardingItem") int shardingItem, @Param("messageType") int messageType, @Param("currentPage") int currentPage, @Param("pageSize") int pageSize);

    /**
     * Batch delete by id list.
     *
     * @param idList the id list
     *
     * @return the int
     */
    int batchDeleteByIdList(@Param("idList") List<Long> idList);

    /**
     * Query message key list list.
     *
     * @param messageKeyList the message key list
     *
     * @return the list
     */
    List<String> queryMessageKeyList(@Param("messageKeyList") List<String> messageKeyList);

    /**
     * Query message list with page list.
     *
     * @param messageQueryDto the message query dto
     *
     * @return the list
     */
    List<MqMessageVo> queryMessageListWithPage(MessageQueryDto messageQueryDto);
}

