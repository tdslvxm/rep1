package com.tdd.online_ddketang.model.pojo;

import java.io.Serializable;
import java.util.Date;

public class Episode implements Serializable {
//           `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
//	         `title` VARCHAR(524) NULL DEFAULT NULL COMMENT '集标题',
//            `num` INT(10) NULL DEFAULT NULL COMMENT '第几集,全局顺序',
//            `ordered` INT(11) NULL DEFAULT NULL COMMENT '顺序，章里面的顺序',
//            `play_url` VARCHAR(256) NULL DEFAULT NULL COMMENT '播放地址',
//            `chapter_id` INT(11) NULL DEFAULT NULL COMMENT '章节主键id',
//            `free` TINYINT(2) NULL DEFAULT '0' COMMENT '0表示免费，1表示首付',
//            `video_id` INT(10) NULL DEFAULT NULL COMMENT '视频id',
//            `create_time` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
    private int id;
    /**
     * '集标题',
     */
    private String title;
    /**
     * '第几集,全局顺序',
     */
    private int num;
    /**
     * '顺序，章里面的顺序',
     */
    private int ordered;
    /**
     * '播放地址',
     */
    private String playUrl;
    /**
     * 章节主键id',
     */
    private int chapterId;
    /**
     *  '0表示免费，1表示首付',
     */
    private byte free;
    /**
     * '视频id',
     */
    private int videoId;
    /**
     * '创建时间',
     */
    private Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getOrdered() {
        return ordered;
    }

    public void setOrdered(int ordered) {
        this.ordered = ordered;
    }

    public String getPlayUrl() {
        return playUrl;
    }

    public void setPlayUrl(String playUrl) {
        this.playUrl = playUrl;
    }

    public int getChapterId() {
        return chapterId;
    }

    public void setChapterId(int chapterId) {
        this.chapterId = chapterId;
    }

    public byte getFree() {
        return free;
    }

    public void setFree(byte free) {
        this.free = free;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
