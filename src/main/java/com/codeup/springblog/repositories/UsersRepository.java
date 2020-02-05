package com.codeup.springblog.repositories;

import com.codeup.springblog.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
