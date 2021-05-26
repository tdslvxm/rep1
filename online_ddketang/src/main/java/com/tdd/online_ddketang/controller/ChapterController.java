package com.tdd.online_ddketang.controller;

import com.tdd.online_ddketang.service.ChapterService;
import com.tdd.online_ddketang.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/pub/Chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @GetMapping("/list")
    public JsonData listchapters(@RequestParam(required = true, value = "video_id") int videoId){

       return JsonData.buildSuccess(chapterService.getChapterByVideoId(videoId)) ;
    }
}
