package com.fogbank.springsecurity.services;

import com.fogbank.springsecurity.entities.Likes;


public interface ILikesService {
       Likes getLikeByUserAndArticle(Integer userId, Integer articleId);

      void deleteById(Integer id) ;

      Likes addLike(Integer userId, Integer articleId);
}

