package com.tdd.online_ddketang.model.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class PlayRecord implements Serializable {

//    	`id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
//	    `user_id` INT(11) NULL DEFAULT NULL,
//	    `video_id` INT(11) NULL DEFAULT NULL,
//	    `current_num` INT(11) NULL DEFAULT NULL COMMENT '当前播放第几集',
//      `episode_id` INT(11) NULL DEFAULT NULL COMMENT '当前播放第几集视频id',
//      `create_time` DATETIME NULL DEFAULT NULL,

    private Integer id;
    private Integer userId;
    private Integer videoId;
    private Integer currentNum;
    private Integer episodeId;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getVideoId() {
        return videoId;
    }

    public void setVideoId(Integer videoId) {
        this.videoId = videoId;
    }

    public Integer getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(Integer currentNum) {
        this.currentNum = currentNum;
    }

    public Integer getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(Integer episodeId) {
        this.episodeId = episodeId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
