package com.galaxy.microservice.rocket.provider.api.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName： ShardingContextDto
 * @Description
 * @Author alan qin
 * @Date 2019-06-13
 **/
@Data
@NoArgsConstructor
public class ShardingContextDto {
    /**
     * The Sharding total count.
     */
    int shardingTotalCount;
    /**
     * The Sharding item.
     */
    int shardingItem;

    public ShardingContextDto(final int shardingTotalCount, final int shardingItem) {
        this.shardingTotalCount = shardingTotalCount;
        this.shardingItem = shardingItem;
    }
}
