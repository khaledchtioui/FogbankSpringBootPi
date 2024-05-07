package com.fogbank.springsecurity.services;

import com.fogbank.springsecurity.entities.Article;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IArticleService {
    List<Article> getAllArticles();
    void deleteArticle(Integer id);
    Article addArticle(Article article, Integer userId);
    Article updateArticle(Article article);
    Article getArticleById(Integer id);

    Article handleImageFileUpload(MultipartFile fileImage, Integer id);

     List<Article> getAllArticlesByUserId(Integer userId);
    String shareFb(Integer id);
}
