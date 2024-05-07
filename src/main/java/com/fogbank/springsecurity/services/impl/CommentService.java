package com.fogbank.springsecurity.services.impl;

import com.fogbank.springsecurity.Repository.ArticleRepository;
import com.fogbank.springsecurity.Repository.CommentRepository;
import com.fogbank.springsecurity.Repository.UserRepository;
import com.fogbank.springsecurity.entities.Article;
import com.fogbank.springsecurity.entities.Comment;
import com.fogbank.springsecurity.entities.User;
import com.fogbank.springsecurity.services.ICommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommentService implements ICommentService {
    CommentRepository commentRepository;
    ArticleRepository articleRepository;
    UserRepository userRepository;
    @Override
    public List<Comment> getAllComments(){
        return  this.commentRepository.findAll();
    }
    @Override
    public Comment addComment(Comment comment, Integer articleId,Integer userId ) {
        Article article = articleRepository.findById(articleId).orElse(null);
        if(article!=null){
            comment.setArticle(article);
        }
        User user = userRepository.findById(userId).orElse(null);
        if(user!=null){
            comment.setUser(user);
        }
        return this.commentRepository.save(comment);
    }
    @Override
    public void deleteComment(Integer idC) {
        this.commentRepository.deleteById(idC);
    }
    @Override
    public Comment updateComment(Comment comment){
        Comment oldComment = commentRepository.findById(comment.getIdc()).orElse(null);
        comment.setArticle(oldComment.getArticle());
        comment.setDatec(oldComment.getDatec());
        comment.setUser(oldComment.getUser());

        return this.commentRepository.save(comment);
    }

    @Override
    public Comment getCommentById(Integer id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public String analyzeSentiment(Comment comment) {
        System.out.println(comment.getComment());
        try {
         //   String pythonScriptPath = "src/main/java/com/fogbank/springsecurity/utils/commentScript.py";

            String pythonScriptPath = "C:/Users/LENOVO/Desktop/Clonegit/FogbankSpringBootPi/src/main/java/com/fogbank/springsecurity/utils/commentScript.py";

            // Commande pour exécuter le script Python
            String command = "python " + pythonScriptPath + " " +  comment.getComment();

            // Execute the command
            Process process = Runtime.getRuntime().exec(command);

            // Read the output of the Python script
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            StringBuilder output = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }

            // Wait for the process to finish
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                return output.toString();
            } else {
                return "Error executing Python script.";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Error: " + e.getMessage();
        }
    }

}
