package com.fogbank.springsecurity.services.impl;

import com.fogbank.springsecurity.Repository.ArticleRepository;
import com.fogbank.springsecurity.Repository.UserRepository;
import com.fogbank.springsecurity.entities.Article;
import com.fogbank.springsecurity.entities.User;
import com.fogbank.springsecurity.services.IArticleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.auth.AccessToken;

@Service
@AllArgsConstructor
public class ArticleService implements IArticleService {

    ArticleRepository articleRepository;
    UserRepository userRepository;

    FileStorageService fileStorageService;
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
    public Article addArticle(Article article, Integer userId){
        User user = userRepository.findById(userId).orElse(null);
        if(article!=null){
            article.setAuteur(user);
        }
        return   this.articleRepository.save(article) ;

    }
    @Override
    public Article updateArticle(Article article){
        Article oldArticle = articleRepository.findById(article.getId()).orElse(null);
        article.setAuteur(oldArticle.getAuteur());
        article.setDate(oldArticle.getDate());
        return   this.articleRepository.save(article) ;

    }
    @Override
    public Article getArticleById(Integer id) {
        return articleRepository.findById(id).orElse(null);
    }

    public Article handleImageFileUpload(MultipartFile fileImage, Integer id) {
        if (fileImage.isEmpty()) {
            return null;
        }
        String fileName = fileStorageService.storeFile(fileImage);
        Article article = articleRepository.findById(id).orElse(null);
        article.setImage(fileName);
        return articleRepository.save(article);
    }

    @Override
    public List<Article> getAllArticlesByUserId(Integer userId) {
        return articleRepository.getByAuteurId(userId);
    }

    @Override
    public String shareFb(Integer id){
        String appId = "232528662540085";
        String appSecret = "60988e9928012f06c205e07717bb4196";
        String accessTokenString = "EAADTe8xUrzUBOyWTEUrsMeXF2dGIaMyNbekWcQEcKFQnmjUAZBC8yhNfHrRAmrLxUYRwWY2fFgZCxHFelKt8x2RcddPe1fPmJ66xFYGZC2dcbsRuZALdFp46zMc9oxe3qPRmBXboxCUzrHkwzC9MzVCMTZCOqpqKI78obb0w8LWZBnAw8YyEaX3st1azN6lWtJqJel6loW1nDKIuLdq2ZBaEIoZD";

        // Set up Facebook4J
        Facebook facebook = new FacebookFactory().getInstance();
        facebook.setOAuthAppId(appId, appSecret);
        facebook.setOAuthAccessToken(new AccessToken(accessTokenString, null));

        // Post a status message
        Article article = articleRepository.findById(id).orElse(null);

        String message = "New Article :" + "\n"+ article.getTitre() + "\n" + article.getContenu()+ "\n" +article.getDate();
        try {
            facebook.postStatusMessage(message);
            return "Status message posted successfully.";
        } catch (FacebookException e) {
            e.printStackTrace();
            System.err.println("Error posting status message: " + e.getMessage());
            return  "Erreur";
        }
    }


}