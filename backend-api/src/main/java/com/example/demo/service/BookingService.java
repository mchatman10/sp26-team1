package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.*;
import com.example.demo.repository.*;

import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepo;

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private ListingRepository listingRepo;

    public Booking create(Long customerId, Long listingId) {

        Customer customer = customerRepo.findById(customerId).orElseThrow();
        Listing listing = listingRepo.findById(listingId).orElseThrow();

        Booking booking = new Booking();
        booking.setCustomer(customer);
        booking.setListing(listing);
        booking.setStatus("CONFIRMED");

        return bookingRepo.save(booking);
    }

    public Booking saveBooking(Long customerId, Long listingId) {
        return create(customerId, listingId);
    }

    public List<Booking> getAllBookings() {
        return bookingRepo.findAll();
    }

    public Booking save(Booking booking) {
        return bookingRepo.save(booking);
    }
}