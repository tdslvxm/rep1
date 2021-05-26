package com.tdd.online_ddketang.service;


import com.tdd.online_ddketang.config.CacheKeyManager;
import com.tdd.online_ddketang.mapper.VideoBannerMapper;
import com.tdd.online_ddketang.model.pojo.VideoBanner;
import com.tdd.online_ddketang.utils.BaseCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 加入guava 缓存技术,目前该技术已经落后市场不用了 只是掌握一下就行
 */
@Service
public class VideoBannerServiceImp implements VideoBannerService {

    @Autowired
    VideoBannerMapper videoBannerMapper;

    @Autowired
    BaseCache baseCache;
    @Override
    public List<VideoBanner> listBanners() {

//        try{
//
//            Object cacheObj =  baseCache.getTenMinuteCache().get(CacheKeyManager.INDEX_BANNER_KEY, ()->{
//
//                List<VideoBanner> bannerList =  videoBannerMapper.listBanners();
//
//                System.out.println("从数据库里面找轮播图列表");
//
//                return bannerList;
//
//            });
//
//            if(cacheObj instanceof List){
//                List<VideoBanner> bannerList = (List<VideoBanner>)cacheObj;
//                return bannerList;
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
        return videoBannerMapper.listBanners();

    }
}

