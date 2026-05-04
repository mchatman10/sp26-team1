package com.example.demo.ui;

import com.example.demo.model.Review;
import com.example.demo.service.ReviewService;
import com.example.demo.service.ListingService;
import com.example.demo.service.ProviderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reviews")
public class ReviewUiController {

    @Autowired
    private ReviewService reviewService;
    @Autowired
    private ListingService listingService;
    @Autowired
    private ProviderService providerService;

    @GetMapping("/reviews")
public String getReviews(Model model) {
    model.addAttribute("reviews", reviewService.getAll());
    return "review-List";
}
    @GetMapping("/listing/id/{id}")
    public String getReviewsByPost(@PathVariable("id") Long listingId, Model model)
    {
        model.addAttribute("reviews", reviewService.getByListingId(listingId));
        System.out.println(reviewService.getAll());
        model.addAttribute("provider", providerService.getProviderById(listingService.getListingById(listingId).getCoachId()));
        model.addAttribute("listing", listingService.getListingById(listingId));
        return "review-List";
    }

    @GetMapping("/create/{listingId}")
    public String showCreateForm(@PathVariable Long listingId, Model model) {

        model.addAttribute("listing", listingService.getListingById(listingId));
        model.addAttribute("review", new Review());

        return "review-create";
    }

    @PostMapping("/create/{listingId}")
    public String createReview(@PathVariable Long listingId, Long customerId, @ModelAttribute Review review)
    {
        reviewService.create(listingId, customerId, review);
        return "redirect:/reviews/listing/" + listingId;
    }
}