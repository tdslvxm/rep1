package com.tdd.online_ddketang.service;

import com.tdd.online_ddketang.mapper.ChapterMapper;
import com.tdd.online_ddketang.model.pojo.Chapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Autowired
    ChapterMapper chapterMapper;

    @Override
    public List<Chapter> getChapterByVideoId(int videoId) {
        return chapterMapper.getChapterByVideoId(videoId);
    }
}
