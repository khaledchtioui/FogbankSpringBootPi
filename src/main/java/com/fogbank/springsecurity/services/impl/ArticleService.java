package com.fogbank.springsecurity.services.impl;

import com.fogbank.springsecurity.Repository.ArticleRepository;
import com.fogbank.springsecurity.Repository.UserRepository;
import com.fogbank.springsecurity.entities.Article;
import com.fogbank.springsecurity.entities.User;
import com.fogbank.springsecurity.services.IArticleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class ArticleService implements IArticleService {

    ArticleRepository articleRepository;
    UserRepository userRepository;
    @Override
    public List<Article> getAllArticles()
    {
        return this.articleRepository.findAll();
    }

    @Override
    public Article getArticleById(Integer id) {
        return this.articleRepository.findById(id).get();
    }

    @Override
    public void deleteArticle(Integer id){
        this.articleRepository.deleteById(id);

    }



    @Override

    public Article addArticle(String auteur, String titre, byte[] photo, String contenu, User userarticle) {
        Article article = new Article();
        article.setAuteur(auteur);
        article.setTitre(titre);
        article.setPhoto(photo);
        article.setContenu(contenu);
        article.setDate(Date.from(java.time.Instant.now()));
        article.setUserarticle(userarticle);

        return articleRepository.save(article);
    }






    @Override
    public Article updateArticle(Article article){
        return   this.articleRepository.save(article) ;

    }
}