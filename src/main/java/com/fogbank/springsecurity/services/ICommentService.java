package com.fogbank.springsecurity.services;

import com.fogbank.springsecurity.entities.Article;
import com.fogbank.springsecurity.entities.Comment;

import java.util.List;

public interface ICommentService {
    List<Comment> getAllComments();
    Comment addComment(Comment comment, Integer articleId,Integer userId);
    void deleteComment(Integer idC);
    Comment updateComment(Comment comment);

    Comment getCommentById(Integer id);

    String analyzeSentiment(Comment comment);
}
