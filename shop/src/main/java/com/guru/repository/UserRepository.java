package com.guru.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guru.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
    
}
