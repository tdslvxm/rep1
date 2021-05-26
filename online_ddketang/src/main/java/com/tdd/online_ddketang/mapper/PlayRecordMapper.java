package com.tdd.online_ddketang.mapper;

import com.tdd.online_ddketang.model.pojo.PlayRecord;
import com.tdd.online_ddketang.model.pojo.VideoOrder;
import org.apache.ibatis.annotations.Param;

public interface PlayRecordMapper {

    /**
     * 增加播放记录
     * @param playRecord
     * @return
     */
    int   save(PlayRecord playRecord);

}
