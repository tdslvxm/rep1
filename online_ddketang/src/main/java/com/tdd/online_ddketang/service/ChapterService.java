package com.tdd.online_ddketang.service;

import com.tdd.online_ddketang.model.pojo.Chapter;

import java.util.List;

public interface ChapterService {
    List<Chapter> getChapterByVideoId(int videoId);

}
