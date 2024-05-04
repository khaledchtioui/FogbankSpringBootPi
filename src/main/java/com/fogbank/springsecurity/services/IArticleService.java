package com.fogbank.springsecurity.services;

import com.fogbank.springsecurity.entities.Article;
import com.fogbank.springsecurity.entities.User;

import java.util.List;

public interface IArticleService {
    List<Article> getAllArticles();

    Article getArticleById(Integer id);

    void deleteArticle(Integer id);

    Article updateArticle(Article article);

    Article addArticle(String auteur, String titre, byte[] photo, String contenu, User userarticle);


}