package com.freelace.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.freelace.demo.Model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    // Additional query methods can be defined here if needed
    
}
