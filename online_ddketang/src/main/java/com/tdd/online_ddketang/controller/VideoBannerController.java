package com.tdd.online_ddketang.controller;

import com.tdd.online_ddketang.model.pojo.VideoBanner;
import com.tdd.online_ddketang.service.VideoBannerService;
import com.tdd.online_ddketang.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/pub/video_banner")
public class VideoBannerController {
    @Autowired
    VideoBannerService videoBannerService;

    @GetMapping("/list")
    public JsonData listVideo(){
        List<VideoBanner> videoBanners = videoBannerService.listBanners();
        return  JsonData.buildSuccess(videoBanners);
    }
}
