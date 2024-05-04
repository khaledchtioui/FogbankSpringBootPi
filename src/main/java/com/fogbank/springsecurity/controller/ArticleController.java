package com.fogbank.springsecurity.controller;

import com.fogbank.springsecurity.Repository.UserRepository;
import com.fogbank.springsecurity.entities.Article;
import com.fogbank.springsecurity.entities.User;
import com.fogbank.springsecurity.services.IArticleService;
import com.fogbank.springsecurity.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Articles")
@AllArgsConstructor
@CrossOrigin(origins = "*", maxAge=3600)

public class ArticleController {

    IArticleService articleService;
    UserService userService;
    private final UserRepository userRepository;

    @GetMapping("")
    public List<Article> getAllArticles() {
     return this.articleService.getAllArticles();
    }
 @GetMapping("/{id}")
    public Article getArticle(@PathVariable Integer id) {
     return this.articleService.getArticleById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable Integer id) {
        this.articleService.deleteArticle(id);
    }

    @GetMapping("/article/{articleId}/photo")
    public ResponseEntity<byte[]> getArticlePhoto(@PathVariable Integer articleId) {
        Article article = articleService.getArticleById(articleId);
            byte[] photo = article.getPhoto();
            if (photo != null && photo.length > 0) {
                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.IMAGE_JPEG); // Assuming image type is JPEG
                return new ResponseEntity<>(photo, headers, HttpStatus.OK);

        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }







    @PostMapping(value = "/addArticleWithUser/{userId}", consumes = {"multipart/form-data"})
    public ResponseEntity<?> addArticleWithUser(@RequestParam("photo") MultipartFile photo,
                                                @RequestParam("auteur") String auteur,
                                                @RequestParam("titre") String titre,
                                                @RequestParam("contenu") String contenu,
                                                @PathVariable Integer userId) {
        try {
            byte[] photoBytes = null;
            if (!photo.isEmpty()) {
                photoBytes = photo.getBytes();
            }

            Optional<User> user = userService.getUserById(userId);
            if (user == null) {
                return ResponseEntity.notFound().build();
            }

            Article article = articleService.addArticle(auteur, titre, photoBytes, contenu, user.get());
            return ResponseEntity.status(HttpStatus.CREATED).body(article);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to process file upload");
        }
    }


    @PutMapping("")
    public Article updateArticle(@RequestBody Article article){
        return  this.articleService.updateArticle(article);

    }
}
