package com.fogbank.springsecurity.services.impl;

import com.fogbank.springsecurity.Repository.ArticleRepository;
import com.fogbank.springsecurity.Repository.CommentRepository;
import com.fogbank.springsecurity.entities.Article;
import com.fogbank.springsecurity.entities.Comment;
import com.fogbank.springsecurity.services.ICommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService implements ICommentService {
    CommentRepository commentRepository;
    ArticleRepository articleRepository;
    @Override
    public List<Comment> getAllComments(){
        return  this.commentRepository.findAll();
    }
    @Override
    public Comment addComment(Comment comment, Integer articleId) {
        Article article = articleRepository.findById(articleId).orElse(null);
        if(article!=null){
            comment.setArticle(article);

        }
        return this.commentRepository.save(comment);
    }
    @Override
    public void deleteComment(Integer idC) {
        this.commentRepository.deleteById(idC);
    }
    @Override
    public Comment updateComment(Comment comment){
        return this.commentRepository.save(comment);
    }
}
