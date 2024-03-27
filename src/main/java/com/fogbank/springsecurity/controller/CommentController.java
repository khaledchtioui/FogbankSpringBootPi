package com.fogbank.springsecurity.controller;

import com.fogbank.springsecurity.entities.Comment;
import com.fogbank.springsecurity.services.ICommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Comment")
@AllArgsConstructor
public class CommentController {


    ICommentService commentService;
    @GetMapping("")
    public List<Comment> getAllComments(){
        return  this.commentService.getAllComments();
    }

    @PostMapping("/{articleId}")
    public Comment addComment(@RequestBody Comment comment, @PathVariable Integer articleId) {
        return this.commentService.addComment(comment, articleId);
    }
    @DeleteMapping("/{IdC}")
    public void deleteArticle(@PathVariable Integer IdC){
        this.commentService.deleteComment(IdC);
    }
    @PutMapping("")
    public Comment updateComment(@RequestBody Comment comment){
        return this.commentService.updateComment(comment);
    }
}