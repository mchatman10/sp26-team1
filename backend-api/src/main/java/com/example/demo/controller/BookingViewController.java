package com.example.demo.controller;

import com.example.demo.service.BookingService;
import com.example.demo.service.ListingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bookings")
public class BookingViewController {

    private final BookingService bookingService;
    private final ListingService listingService;

    public BookingViewController(BookingService bookingService, ListingService listingService) {
        this.bookingService = bookingService;
        this.listingService = listingService;
    }

    @GetMapping("/new/{listingId}")
    public String showBookingForm(@PathVariable Long listingId, Model model) {
        model.addAttribute("listing", listingService.getListingById(listingId));
        return "booking-form";
    }

    @PostMapping
    public String createBooking(@RequestParam Long customerId,
            @RequestParam Long listingId) {

        bookingService.saveBooking(customerId, listingId);
        return "redirect:/services";
    }
}