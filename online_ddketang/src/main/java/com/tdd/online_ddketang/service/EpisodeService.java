package com.tdd.online_ddketang.service;

import com.tdd.online_ddketang.model.pojo.Episode;

import java.util.List;

public interface EpisodeService {
    /**
     * chapterId查对应的Episode
     * @return
     */
    List<Episode> getEpisodeByChapterId(int chapterId);

    Episode findFirstEpisodeByVideoId(int videoId);
}
