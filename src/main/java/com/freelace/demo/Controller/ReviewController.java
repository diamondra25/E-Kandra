package com.freelace.demo.Controller;

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

import com.freelace.demo.Model.Review;
import com.freelace.demo.Service.ReviewService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @GetMapping()
    public List<Review> getAll() {
        return reviewService.getAll();
    }

    @GetMapping("/{id}")
    public Review getById(@PathVariable Long id) {
        return reviewService.getById(id);
    }

    @PostMapping
    public Review create(@RequestBody Review review) {
        return reviewService.create(review);
    }

    @PutMapping("/{id}")
    public Review update(@PathVariable Long id,@RequestBody Review reviewDetails) {
        return reviewService.update(id, reviewDetails);
    }
    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        reviewService.delete(id);
    }

    @DeleteMapping()
    public void deleteAll() {
        reviewService.deleteAll();
    }
}
