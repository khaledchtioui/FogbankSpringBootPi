package com.fogbank.springsecurity.services.impl;

import com.fogbank.springsecurity.Repository.ArticleRepository;
import com.fogbank.springsecurity.entities.Article;
import com.fogbank.springsecurity.services.IArticleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ArticleService implements IArticleService {

    ArticleRepository articleRepository;
    @Override
    public List<Article> getAllArticles()
    {
        return this.articleRepository.findAll();
    }
    @Override
    public void deleteArticle(Integer id){
        this.articleRepository.deleteById(id);

    }

    @Override
    public Article addArticle(Article article){
        return   this.articleRepository.save(article) ;

    }
    @Override
    public Article updateArticle(Article article){
        return   this.articleRepository.save(article) ;

    }
}