package com.tdd.online_ddketang.mapper;

import com.tdd.online_ddketang.model.pojo.Video;

import java.util.List;

public interface VideoMapper {

     List<Video> listVideos();

     Video getVideoById(Integer id);
}
