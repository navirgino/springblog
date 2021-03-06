package com.codeup.springblog.repositories;

import com.codeup.springblog.Post;
import com.codeup.springblog.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
