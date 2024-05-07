package com.fogbank.springsecurity.controller;

import com.fogbank.springsecurity.entities.Article;
import com.fogbank.springsecurity.services.IArticleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.time.Instant;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/Articles")
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)

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

    @PostMapping("/{userId}")
    public Article addArticle(@RequestBody Article article, @PathVariable Integer userId){
       article.setDate(Date.from(Instant.now()));
        return   this.articleService.addArticle(article, userId) ;
    }


    @PutMapping("")
    public Article updateArticle(@RequestBody Article article){
        return  this.articleService.updateArticle(article);

    }
    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable Integer id) {
        return this.articleService.getArticleById(id);
    }


    @CrossOrigin(origins = "*", allowedHeaders = "Requestor-Type", exposedHeaders = "X-Get-Header")
    @PostMapping("/uploadImage/{id}")
    public Article handleImageFileUpload(@RequestParam("fileImage") MultipartFile fileImage, @PathVariable Integer id) {
        return this.articleService.handleImageFileUpload(fileImage,id);
    }

    @PostMapping("/shareFb/{id}")
    public String shareFb(@PathVariable Integer id){
        return articleService.shareFb(id);
    }

    @GetMapping("/user/{userId}")
    public List<Article> getAllArticlesByUserId(@PathVariable Integer userId) {
        return this.articleService.getAllArticlesByUserId(userId);
    }

}
