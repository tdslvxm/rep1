package com.tdd.online_ddketang.service;

import com.tdd.online_ddketang.model.pojo.Episode;
import com.tdd.online_ddketang.model.pojo.Video;
import com.tdd.online_ddketang.model.pojo.VideoOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VideoOrderService {

    /**
     * 下单
     * @param
     * @return
     */
    int   save(Integer userId, int videoId) ;
}
