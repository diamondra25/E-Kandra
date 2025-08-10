package com.example.ikandra.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ikandra.Model.Review;

public interface Reviewrepository extends JpaRepository<Review, Long> {
    
}
