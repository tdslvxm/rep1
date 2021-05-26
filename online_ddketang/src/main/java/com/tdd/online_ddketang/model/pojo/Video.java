package com.tdd.online_ddketang.model.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Video implements Serializable {

//    CREATE TABLE `video` (
//            `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
//	`title` VARCHAR(524) NULL DEFAULT NULL COMMENT '视频标题',
//            `summary` VARCHAR(1026) NULL DEFAULT NULL COMMENT '概述',
//            `cover_img` VARCHAR(524) NULL DEFAULT NULL COMMENT '封面图',
//            `price` INT(11) NULL DEFAULT NULL COMMENT '价格,分',
//            `create_time` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
//            `point` DOUBLE(11,2) NULL DEFAULT '8.70' COMMENT '默认8.7，最高10分',
//    PRIMARY KEY (`id`)
//)
//    COLLATE='utf8_general_ci'
//    ENGINE=InnoDB
//            AUTO_INCREMENT=48
//            ;

    private Integer id;
    /**
     * '视频标题',
     */
    private String title;
    /**
     * '概述',
     */
    private String summary;
    /**
     * '封面图',
     */
    private String coverImg;
    /**
     * '价格,分',
     */
    private Integer price;
    /**
     * '创建时间',
     */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    /**
     * 评分 '默认8.7，最高10分',
     */
    private Double point;

    /**
     * 一对多 每个video下面有多个章
     */
    List<Chapter> chapters;

    public List<Chapter> getChapters() {
        return chapters;
    }

    public void setChapters(List<Chapter> chapters) {
        this.chapters = chapters;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "VideoMapper{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", coverImg='" + coverImg + '\'' +
                ", price=" + price +
                ", createTime=" + createTime +
                ", point=" + point +
                '}';
    }
}
