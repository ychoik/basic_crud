package com.example.escCamp.Repository;

import com.example.escCamp.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post>findByTitleContaining(String keyword);
}
