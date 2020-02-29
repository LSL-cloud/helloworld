package com.itheima.mongo.repostory;

import com.itheima.mongo.entity.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

// 第一个泛型：实体类
// 第二个泛型：id的数据类型
public interface CommentRepos extends MongoRepository<Comment, String> {
    List<Comment> findByArticleId(String articleId);
}
