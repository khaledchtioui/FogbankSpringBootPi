package com.fogbank.springsecurity.Repository;

import com.fogbank.springsecurity.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository  extends JpaRepository<Article, Integer> {
    List<Article> getByAuteurId(Integer userId);
}
