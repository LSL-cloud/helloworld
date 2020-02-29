package com.itheima.mongo.controller;

import com.itheima.mongo.entity.Comment;
import com.itheima.mongo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentService commentService;

    // 新增评论
    @PostMapping("comment")
    public String insertComment(@RequestBody Comment comment){
        commentService.insertComment(comment);
        return "success";
    }

    // 查看所有评论
    @GetMapping("comment")
    public List<Comment> findAll(){
        List<Comment> commen = commentService.findAll();
        return commen;
    }

    // 根据id查询
    @GetMapping("comment/{id}")
    public Comment findById(@PathVariable("id") String id){
        Comment comment = commentService.findById(id);
        return comment;
    }

    // 修改评论
    @PutMapping("comment/{id}")
    public String update(@PathVariable("id") String id,
                         @RequestBody Comment comment){
        commentService.update(id, comment);
        return "success";
    }

    // 删除评论
    @DeleteMapping("comment/{id}")
    public String delete(@PathVariable("id") String id){
        commentService.delete(id);
        return "success";
    }

    // 根据文章id查询评论
    @GetMapping("comment/article/{id}")
    public List<Comment> findByArticle(@PathVariable("id") String articleId){
        List<Comment> comments = commentService.findByArticle(articleId);
        return comments;
    }
}
