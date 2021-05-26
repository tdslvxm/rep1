package com.tdd.online_ddketang.service;

import com.tdd.online_ddketang.mapper.VideoMapper;
import com.tdd.online_ddketang.model.pojo.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VideoServiceImp implements VideoService {
    @Autowired
    private  VideoMapper videoMapper;
    @Override
    public List<Video> listVideos() {
        return videoMapper.listVideos();
    }

    @Override
    public Video getVideoById(Integer id) {
        return videoMapper.getVideoById(id);
    }
}
