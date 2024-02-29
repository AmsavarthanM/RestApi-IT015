package com.example.projectweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.projectweb.model.Home;

@Repository
public interface HomeRepo extends JpaRepository<Home, Integer> {
    
}
