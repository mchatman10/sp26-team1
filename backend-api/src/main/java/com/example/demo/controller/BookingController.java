package com.example.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.model.Booking;
import com.example.demo.model.Customer;
import com.example.demo.model.Listing;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.repository.ListingRepository;
import com.example.demo.service.BookingService;
import org.springframework.ui.Model;

@Controller
public class BookingController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ListingRepository listingRepository;

    @Autowired
    private BookingService bookingService;

    @GetMapping("/book/{listingId}")
    public String showPayment(@PathVariable Long listingId, Model model) {
        model.addAttribute("listingId", listingId);
        return "payment";
    }

    @PostMapping("/book/confirm/{listingId}")
    public String confirmBooking(@PathVariable Long listingId,
            Principal principal,
            RedirectAttributes redirectAttributes) {

        Customer customer = customerRepository
                .findByEmail(principal.getName())
                .orElseThrow();

        Listing listing = listingRepository
                .findById(listingId)
                .orElseThrow();

        Booking booking = new Booking();
        booking.setCustomer(customer);
        booking.setListing(listing);

        bookingService.save(booking);

        redirectAttributes.addFlashAttribute("message", "Payment successful! Booking created.");

        return "redirect:/services";
    }
}