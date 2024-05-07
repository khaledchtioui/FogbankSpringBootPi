package com.fogbank.springsecurity.Repository;

import com.fogbank.springsecurity.entities.Article;
import com.fogbank.springsecurity.entities.Likes;
import com.fogbank.springsecurity.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikesRepository extends JpaRepository<Likes,Integer> {
    Likes findByUser(User userId);
    Likes findByUserAndArticle(User user, Article article);
}
