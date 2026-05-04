package com.example.demo.controller;

import com.example.demo.model.Booking;
import com.example.demo.model.Customer;
import com.example.demo.model.Listing;
import com.example.demo.repository.BookingRepository;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.service.ListingService;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class ListingViewController {

    private final ListingService listingService;

    public ListingViewController(ListingService listingService) {
        this.listingService = listingService;
    }

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @GetMapping("/services")
    public String showServices(Model model, Principal principal) {

        List<Listing> listings = listingService.getAllListings();

        for (Listing listing : listings) {
            listing.setVisibleReviews(reviewRepository.findForListing(listing.getSessionId()));
        }

        if (principal != null) {
            Customer customer = customerRepository
                    .findByEmail(principal.getName())
                    .orElse(null);

            List<Booking> bookings = bookingRepository.findAll();

            for (Listing l : listings) {
                boolean booked = bookings.stream()
                        .anyMatch(b -> b.getCustomer() != null &&
                                b.getListing() != null &&
                                customer != null &&
                                b.getCustomer().getCustomerId().equals(customer.getCustomerId()) &&
                                b.getListing().getSessionId().equals(l.getSessionId()));

                l.setBooked(booked);
            }
        }

        model.addAttribute("listings", listings);
        return "services";
    }
}
