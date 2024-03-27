package com.fogbank.springsecurity.controller;

import com.fogbank.springsecurity.entities.Article;
import com.fogbank.springsecurity.services.IArticleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Articles")
@AllArgsConstructor
public class ArticleController {

    IArticleService articleService;

   @GetMapping("")
public List<Article> getAllArticles() {
     return this.articleService.getAllArticles();
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable Integer id) {
        this.articleService.deleteArticle(id);
    }

    @PostMapping("")
    public Article addArticle(@RequestBody Article article){
       article.setDate(Date.from(Instant.now()));
        return   this.articleService.addArticle(article) ;

    }


    @PutMapping("")
    public Article updateArticle(@RequestBody Article article){
        return  this.articleService.updateArticle(article);

    }
}
