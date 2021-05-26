package com.tdd.online_ddketang.controller;

import com.tdd.online_ddketang.model.pojo.Video;
import com.tdd.online_ddketang.service.VideoService;
import com.tdd.online_ddketang.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/pub/video")
public class VideoController {
    @Autowired
    VideoService videoService;

    @GetMapping("/list")
    public JsonData listVideo(){
        List<Video> videos = videoService.listVideos();
        return  JsonData.buildSuccess(videos);
    }

    /**
     * 通过videoId查询video的详细信息   三表联合
     * @param videoId
     * @return
     */
    @GetMapping("/find_detail_by_id")
    public JsonData getVideoDetailById(@RequestParam(name="video_id",required = true) Integer videoId){
        return  JsonData.buildSuccess(videoService.getVideoById(videoId));
    }


}
