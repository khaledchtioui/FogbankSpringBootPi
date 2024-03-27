package com.fogbank.springsecurity.Repository;

import com.fogbank.springsecurity.entities.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository  extends JpaRepository<Article, Integer> {
}
