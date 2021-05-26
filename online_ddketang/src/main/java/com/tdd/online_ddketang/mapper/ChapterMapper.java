package com.tdd.online_ddketang.mapper;

import com.tdd.online_ddketang.model.pojo.Chapter;

import java.util.List;

public interface ChapterMapper {
     /**
      * 通过videoId查询对应chapter
      * @return
      */
     List<Chapter> getChapterByVideoId(int videoId);
}
