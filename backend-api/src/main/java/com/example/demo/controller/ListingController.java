package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Listing;
import com.example.demo.service.ListingService;
import java.util.List;

//@RestController
@RequestMapping("/listings")
public class ListingController {
    @Autowired
    private ListingService service;

    @GetMapping
    public List<Listing> getAll() {
        return service.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Listing> getListingById(@PathVariable long id)
    {
        Listing listing = service.getListingById(id);
        if (listing != null) 
            {
            return ResponseEntity.ok(listing);
            }
        else
            {
            return ResponseEntity.notFound().build();
            }  
    }

    @PostMapping
    public Listing create(@RequestBody Listing listing) {
        return service.createListing(listing);
    }
}