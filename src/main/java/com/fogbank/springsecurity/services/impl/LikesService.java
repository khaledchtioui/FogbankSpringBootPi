package com.fogbank.springsecurity.services.impl;

import com.fogbank.springsecurity.Repository.ArticleRepository;
import com.fogbank.springsecurity.Repository.LikesRepository;
import com.fogbank.springsecurity.Repository.UserRepository;
import com.fogbank.springsecurity.entities.Article;
import com.fogbank.springsecurity.entities.Likes;
import com.fogbank.springsecurity.entities.User;
import com.fogbank.springsecurity.services.ILikesService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LikesService implements ILikesService {
    LikesRepository likesRepository;
    ArticleRepository articleRepository;
    UserRepository userRepository;


    @Override
    public Likes getLikeByUserAndArticle(Integer userId, Integer articleId) {
        Article article = articleRepository.findById(articleId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        return likesRepository.findByUserAndArticle(user, article);
    }

    @Override
    public void deleteById(Integer id) {
        likesRepository.deleteById(id);
    }

    @Override
    public Likes addLike(Integer userId, Integer articleId) {
        Article article = articleRepository.findById(articleId).orElse(null);
        User user = userRepository.findById(userId).orElse(null);
        Likes like = new Likes();
        like.setUser(user);
        like.setArticle(article);
        return likesRepository.save(like);
    }



}
