package com.itheima.mongo.service;

import com.itheima.mongo.entity.Comment;
import com.itheima.mongo.repostory.CommentRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private CommentRepos repos;

    private int count = 10;

    // 新增评论
    public void insertComment(Comment comment) {
        // 生成主键
        comment.setId(String.valueOf(count++));
        // 设置默认点赞数
        comment.setThumbup(0);
        // 设置发布日期
        comment.setPublishDate(new Date());
        comment.setArticleId("1");
        repos.insert(comment);
    }

    // 查看所有评论
    public List<Comment> findAll() {
        List<Comment> commen = repos.findAll();
        return commen;
    }

    // 根据id查询
    public Comment findById(String id) {
        Optional<Comment> optional = repos.findById(id);
        // 通过ID查询的数据有可能为null值,如果直接调用Optional.get可能会出现空指针异常
        // optional.orElse(null): 如果返回值为null的情况下,直接返回null即可
        Comment comment = optional.orElse(null);
        return comment;
    }

    // 修改评论
    public void update(String id, Comment comment) {
        comment.setId(id);
        // 如果数据存在，执行修改，如果不存在，执行插入
        repos.save(comment);
    }

    // 删除评论
    public void delete(String id) {
        repos.deleteById(id);
    }

    // 根据文章id查询评论
    public List<Comment> findByArticle(String articleId) {

        List<Comment> comments = repos.findByArticleId(articleId);
        return comments;

    }
}
