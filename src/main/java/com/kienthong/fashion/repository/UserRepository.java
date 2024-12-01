package com.kienthong.fashion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kienthong.fashion.models.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    User findByUsername(String userName);
}
