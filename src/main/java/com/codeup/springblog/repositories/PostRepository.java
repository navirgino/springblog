package com.codeup.springblog.repositories;

import com.codeup.springblog.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    List<Post> findAll();
    Post findById(long id);


}
