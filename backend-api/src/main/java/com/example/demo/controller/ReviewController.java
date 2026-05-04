package com.example.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Customer;
import com.example.demo.model.Listing;
import com.example.demo.model.Review;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ListingRepository;
import com.example.demo.service.ReviewService;

@Controller
public class ReviewController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ListingRepository listingRepository;
    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ReviewService reviewService;

    @PostMapping("/review/{listingId}")
    public String submitReview(@PathVariable Long listingId,
            @ModelAttribute Review review,
            Principal principal,
            RedirectAttributes redirectAttributes) {

        Customer customer = customerRepository
                .findByEmail(principal.getName())
                .orElseThrow();

        boolean hasBooked = bookingRepository.findAll().stream()
                .anyMatch(b -> b.getCustomer().getCustomerId().equals(customer.getCustomerId())
                        && b.getListing().getSessionId().equals(listingId));

        if (!hasBooked) {
            redirectAttributes.addFlashAttribute("message", "You must book before reviewing.");
            return "redirect:/services";
        }

        Listing listing = listingRepository.findById(listingId).orElseThrow();

        review.setCustomer(customer);
        review.setListing(listing);

        reviewService.save(review);

        return "redirect:/services";
    }
}