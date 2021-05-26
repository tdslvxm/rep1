package com.tdd.online_ddketang.service;

import com.tdd.online_ddketang.exception.DDexception;
import com.tdd.online_ddketang.mapper.EpisodeMapper;
import com.tdd.online_ddketang.mapper.PlayRecordMapper;
import com.tdd.online_ddketang.mapper.VideoMapper;
import com.tdd.online_ddketang.mapper.VideoOrderMapper;
import com.tdd.online_ddketang.model.pojo.Episode;
import com.tdd.online_ddketang.model.pojo.PlayRecord;
import com.tdd.online_ddketang.model.pojo.Video;
import com.tdd.online_ddketang.model.pojo.VideoOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
public class VideoOrderServiceImpl implements  VideoOrderService{

    @Autowired
    VideoOrderMapper videoOrderMapper;

    @Autowired
    VideoMapper videoMapper;

    @Autowired
    PlayRecordMapper playRecordMapper;

    @Autowired
    EpisodeMapper episodeMapper;


    @Override
    @Transactional//开启事务
    public int save(Integer userId, int videoId) {
        VideoOrder videoOrder = videoOrderMapper.findVideoOrderByVideoIdAndUserId(userId, videoId);
        if (videoOrder!=null){//已有数据
            throw  new DDexception(-1, "请勿重复下单");
//                return  0;
        }
        Video video = videoMapper.getVideoById(videoId);
        if (video==null){//video不存在
            return  0;
        }

        //构造订单信息并保存
        VideoOrder order = new VideoOrder();
        order.setCreateTime(new Date());
        order.setState(1);
        order.setOutTradeNo(UUID.randomUUID().toString());
        order.setUserId(userId);
        order.setTotalFee(video.getPrice());
        order.setVideoId(videoId);
        order.setVideoImg(video.getCoverImg());
        order.setVideoTitle(video.getTitle());
        int rows = videoOrderMapper.save(order);


        //保存播放记录,播放记录需要Episode相关的信息 所以需要把Episode查询出来
        if (rows==1){
            Episode episode = episodeMapper.findFirstEpisodeByVideoId(videoId);
            if (episode==null){
                throw  new DDexception(-1, "episode不存在,请联系管理员");
            }
            PlayRecord playRecord = new PlayRecord();
            playRecord.setCreateTime(new Date());
            playRecord.setCurrentNum(episode.getNum());
            playRecord.setEpisodeId(episode.getId());
            playRecord.setUserId(userId);
            playRecord.setVideoId(videoId);

            playRecordMapper.save(playRecord);
        }

        return rows;

    }
}
