package com.itheima.mongo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Comment {
    // id
    private String id;

    // 文章ID
    private String articleId;

    // 评论内容
    private String content;

    // 评论人ID
    private String userId;

    // 评论ID
    private String parentId;

    // 评论日期
    private Date publishDate;

    // 点赞数
    private Integer thumbup;
}
