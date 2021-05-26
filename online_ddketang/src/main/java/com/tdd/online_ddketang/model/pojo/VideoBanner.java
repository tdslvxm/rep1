package com.tdd.online_ddketang.model.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class VideoBanner implements Serializable {
//    CREATE TABLE `video_banner` (
//            `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT,
//	          `url` VARCHAR(256) NULL DEFAULT NULL COMMENT '跳转地址',
//            `img` VARCHAR(256) NULL DEFAULT NULL COMMENT '图片地址',
//            `create_time` DATETIME NULL DEFAULT NULL,
//	`           weight` INT(11) NULL DEFAULT NULL COMMENT '数字越小排越前',
//    PRIMARY KEY (`id`)
//)
//    COLLATE='utf8mb4_general_ci'
//    ENGINE=InnoDB
//            AUTO_INCREMENT=5
//            ;

    private int id;
    private String url;//'跳转地址',
    private String img;  //'图片地址',
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date createTime;
    private int weight;//'数字越小排越前',

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "VideoBanner{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", img='" + img + '\'' +
                ", createTime=" + createTime +
                ", weight=" + weight +
                '}';
    }
}
