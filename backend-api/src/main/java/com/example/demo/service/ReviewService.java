package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.*;
import com.example.demo.repository.*;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepo;

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private ListingRepository listingRepo;

    @Autowired
    private BookingRepository bookingRepo;

    public Review create(Long customerId, Long listingId, Review review) {

        boolean purchased = bookingRepo.findAll().stream()
            .anyMatch(b -> b.getCustomer().getCustomerId().equals(customerId)
                        && b.getListing().getSessionId().equals(listingId));

        if (!purchased) {
            throw new RuntimeException("Customer has not purchased this service");
        }

        review.setCustomer(customerRepo.findById(customerId).orElseThrow());
        review.setListing(listingRepo.findById(listingId).orElseThrow());

        return reviewRepo.save(review);
    }
}