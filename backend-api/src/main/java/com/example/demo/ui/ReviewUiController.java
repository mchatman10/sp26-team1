package com.example.demo.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.example.demo.model.Review;
import com.example.demo.service.ReviewService;

@Controller
@RequestMapping("/reviews")
public class ReviewUiController {

    @Autowired
    private ReviewService service;

    @PostMapping
    public Review create(@RequestParam Long customerId, @RequestParam Long listingId, @RequestBody Review review) {
        return service.create(customerId, listingId, review);
    }
}
