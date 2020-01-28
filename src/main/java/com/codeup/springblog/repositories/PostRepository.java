package com.codeup.springblog.repositories;

import com.codeup.springblog.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findByOrderByTitle();
    List<Post> findAll();
    Post findByTitle(String title);
//    Post findByBody(String body);
//    Post findById(long id);

}
