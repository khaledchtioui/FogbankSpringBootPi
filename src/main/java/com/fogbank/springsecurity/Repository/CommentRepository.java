package com.fogbank.springsecurity.Repository;

import com.fogbank.springsecurity.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  CommentRepository extends JpaRepository<Comment,Integer> {
}
