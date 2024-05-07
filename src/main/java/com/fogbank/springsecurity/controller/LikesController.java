package com.fogbank.springsecurity.controller;

import com.fogbank.springsecurity.entities.Article;
import com.fogbank.springsecurity.entities.Likes;
import com.fogbank.springsecurity.services.IArticleService;
import com.fogbank.springsecurity.services.ILikesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.Date;

@RestController
@RequestMapping("/Likes")
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge = 3600)
public class LikesController {
    ILikesService likesService;

    @DeleteMapping("/{id}")
    public void deleteLike(@PathVariable Integer id) {
        this.likesService.deleteById(id);
    }

    @PostMapping("/{userId}/{articleId}")
    public Likes addLike(@PathVariable Integer userId, @PathVariable Integer articleId){
        return   this.likesService.addLike(userId, articleId) ;
    }

    @GetMapping("/{userId}/{articleId}")
    public Likes getLikeByUserAndArticle(@PathVariable Integer userId, @PathVariable Integer articleId) {
        return this.likesService.getLikeByUserAndArticle(userId, articleId);
    }
}



