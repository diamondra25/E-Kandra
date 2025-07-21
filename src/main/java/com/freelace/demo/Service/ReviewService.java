package com.freelace.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.freelace.demo.Model.Review;
import com.freelace.demo.Repository.ReviewRepository;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    public Review getById(Long id) {
        return reviewRepository.findById(id).orElse(null);
    }

    public Review create(Review review) {
        return reviewRepository.save(review);
    }

    public Review update(Long id, Review reviewDetails) {
        Review review = getById(id);
        if (review != null) {
            review.setRating(reviewDetails.getRating());
            review.setOrder(reviewDetails.getOrder());
            return reviewRepository.save(review);
        }
        return null;
    }

    public void delete(Long id) {
        reviewRepository.deleteById(id);
    }

    public void deleteAll() {
        reviewRepository.deleteAll();
    }
}
