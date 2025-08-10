package com.example.ikandra.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ikandra.Model.Review;
import com.example.ikandra.Repository.Reviewrepository;

@Service
public class ReviewService {
    
    @Autowired
    private Reviewrepository reviewrepository;

    public List<Review> getAll(){
        return reviewrepository.findAll();
    }

    public Review create(Review review){
        return reviewrepository.save(review);
    }

    public Review update(Review review)
    {
        Review existReview = reviewrepository.findById(review.getId()).orElse(null);
        if(existReview!=null){
            return reviewrepository.save(existReview);
        }
        return null;
    }

    public void deleteById(Long id) {
        reviewrepository.deleteById(id);
    }

    public void deleteAll(){
        reviewrepository.deleteAll();
    }

}
