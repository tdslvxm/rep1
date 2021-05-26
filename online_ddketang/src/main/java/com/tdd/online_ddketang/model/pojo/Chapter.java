package com.tdd.online_ddketang.model.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Chapter implements Serializable {
//    	      `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
//	          `video_id` INT(11) NULL DEFAULT NULL COMMENT '视频主键',
//            `title` VARCHAR(128) NULL DEFAULT NULL COMMENT '章节名称',
//            `ordered` INT(11) NULL DEFAULT NULL COMMENT '章节顺序',
//            `create_time` DATETIME NULL DEFAULT NULL COMMENT '创建时间',

    private int id;
    /**
     * '视频主键',
     */
    private int videoId;
    /**
     * '章节名称',
     */
    private  String title;
    /**
     * '章节顺序',
     */
    private int ordered;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    /**
     * '创建时间',
     */
    private Date createTime;

    /**
     * 每章对应的集
     */
    private List<Episode> episodes;

    public int getId() {
        return id;
    }

    public List<Episode> getEpisodes() {
        return episodes;
    }

    public void setEpisodes(List<Episode> episodes) {
        this.episodes = episodes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOrdered() {
        return ordered;
    }

    public void setOrdered(int ordered) {
        this.ordered = ordered;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Chapter{" +
                "id=" + id +
                ", videoId=" + videoId +
                ", title='" + title + '\'' +
                ", ordered=" + ordered +
                ", createTime=" + createTime +
                '}';
    }
}
