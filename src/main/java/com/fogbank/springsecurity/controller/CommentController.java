package com.fogbank.springsecurity.controller;

import com.fogbank.springsecurity.entities.Article;
import com.fogbank.springsecurity.entities.Comment;
import com.fogbank.springsecurity.services.ICommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Comment")
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)

public class CommentController {


    ICommentService commentService;
    @GetMapping("")
    public List<Comment> getAllComments(){
        return  this.commentService.getAllComments();
    }

    @PostMapping("/{articleId}/{userId}")
    public Comment addComment(@RequestBody Comment comment, @PathVariable Integer articleId,@PathVariable Integer userId) {
        return this.commentService.addComment(comment, articleId, userId);
    }
    @DeleteMapping("/{idc}")
    public void deleteArticle(@PathVariable Integer idc){
        this.commentService.deleteComment(idc);
    }
    @PutMapping("")
    public Comment updateComment(@RequestBody Comment comment){
        return this.commentService.updateComment(comment);
    }

    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable Integer id) {
        return this.commentService.getCommentById(id);
    }

    @PostMapping("/sentiment/analyse")
    public Comment analyzeSentiment(@RequestBody Comment comment) {
         commentService.analyzeSentiment(comment);
         Comment data = new Comment();
         data.setComment(commentService.analyzeSentiment(comment));
         return  data;
    }

}