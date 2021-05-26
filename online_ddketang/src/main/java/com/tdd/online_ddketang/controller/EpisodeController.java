package com.tdd.online_ddketang.controller;

import com.tdd.online_ddketang.exception.DDexception;
import com.tdd.online_ddketang.service.EpisodeService;
import com.tdd.online_ddketang.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/v1/pub/episode")
public class EpisodeController {
    @Autowired
    EpisodeService episodeService;

    @GetMapping("/list")
    public JsonData getEpisodeByChapterId(@RequestParam(required = true,value = "chapter_id") int chapterId){
//        int num = 10;
//        if (num==10){
//            throw  new DDexception(-1, "抛出自定义异常,比如用户账户密码错误之类的api/v1/pub/episode/list 测试,记得注释掉");
//        }
        return  JsonData.buildSuccess(episodeService.getEpisodeByChapterId(chapterId));
    }

    @GetMapping("/one")
    public JsonData findFirstEpisodeByVideoId(@RequestParam(required = true,value = "video_id") int videoId){


        return  JsonData.buildSuccess(episodeService.findFirstEpisodeByVideoId(videoId));
    }


}
