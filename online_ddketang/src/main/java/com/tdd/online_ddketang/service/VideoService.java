package com.tdd.online_ddketang.service;

import com.tdd.online_ddketang.model.pojo.Video;

import java.util.List;

public interface VideoService {

    public List<Video> listVideos();

    Video getVideoById(Integer id);
}
