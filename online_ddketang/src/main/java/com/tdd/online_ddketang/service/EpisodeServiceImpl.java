package com.tdd.online_ddketang.service;

import com.tdd.online_ddketang.mapper.EpisodeMapper;
import com.tdd.online_ddketang.model.pojo.Episode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EpisodeServiceImpl implements EpisodeService{
    @Autowired
    EpisodeMapper episodeMapper;
    @Override
    public List<Episode> getEpisodeByChapterId(int chapterId) {
        return episodeMapper.getEpisodeByChapterId(chapterId);
    }

    @Override
    public Episode findFirstEpisodeByVideoId(int videoId) {
        Episode episode = episodeMapper.findFirstEpisodeByVideoId(videoId);
        System.out.println(episode+"-----------------------------------------------------");
        return episode;
    }
}
