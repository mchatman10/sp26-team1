package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Review;
import com.example.demo.service.ReviewService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @Autowired
    private ReviewService service;

    @PostMapping
    public Review create(@RequestParam Long customerId, @RequestParam Long listingId, @RequestBody Review review) {
        return service.create(customerId, listingId, review);
    }
}