package com.tdd.online_ddketang.mapper;

import com.tdd.online_ddketang.model.pojo.VideoOrder;
import org.apache.ibatis.annotations.Param;

public interface VideoOrderMapper {
    /**
     *  查询用户是否购买过此商品
     * @param userId
     * @param videoId
     * @return
     */
    VideoOrder findVideoOrderByVideoIdAndUserId(@Param("user_id") Integer userId, @Param("video_id")int videoId);

    /**
     * 下单
     * @param videoOrder
     * @return
     */
    int   save(VideoOrder videoOrder);

}
