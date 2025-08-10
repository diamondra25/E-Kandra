package com.example.ikandra.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ikandra.Model.Review;
import com.example.ikandra.Service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping()
    public List<Review> getAll(){
        return reviewService.getAll();
    }

    @PostMapping()
    public Review create(@RequestBody Review review){
        return reviewService.create(review);
    }

    @PutMapping()
    public Review update(@RequestBody Review review){
        return reviewService.update(review);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id){
        reviewService.deleteById(id);
    }

    @DeleteMapping()
    public void deleteAll(){
        reviewService.deleteAll();
    }
}
