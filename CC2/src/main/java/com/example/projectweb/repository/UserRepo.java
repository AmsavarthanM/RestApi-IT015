package com.example.projectweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projectweb.model.User;

public interface  UserRepo extends JpaRepository<User,Integer>{
    
}
