package com.tdd.online_ddketang.mapper;

import com.tdd.online_ddketang.model.pojo.Episode;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EpisodeMapper {
     /**
      * chapterId查对应的Episode
      * @return
      */
     List<Episode> getEpisodeByChapterId(int chapterId);

     /**
      * 通过videoId查询到第一条数据
      * @param videoId
      * @return
      */
     Episode findFirstEpisodeByVideoId(@Param("video_id") int videoId);
}
