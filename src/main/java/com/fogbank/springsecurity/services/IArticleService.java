package com.fogbank.springsecurity.services;

import com.fogbank.springsecurity.entities.Article;

import java.util.List;

public interface IArticleService {
    List<Article> getAllArticles();
    void deleteArticle(Integer id);
    Article addArticle(Article article);
    Article updateArticle(Article article);
}
