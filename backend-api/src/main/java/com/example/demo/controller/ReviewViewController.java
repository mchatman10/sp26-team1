package com.example.demo.controller;

import com.example.demo.model.Review;
import com.example.demo.service.ReviewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reviews")
public class ReviewViewController {

    private final ReviewService reviewService;

    public ReviewViewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/new")
    public String showReviewForm(Model model) {
        model.addAttribute("review", new Review());
        return "review-form";
    }

    @PostMapping
    public String saveReview(@RequestParam Long customerId,
            @RequestParam Long listingId,
            @ModelAttribute Review review) {

        reviewService.saveReview(customerId, listingId, review);
        return "redirect:/services";
    }
}