package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Listing;
import com.example.demo.service.ListingService;
import java.util.List;

@RestController
@RequestMapping("/listings")
public class ListingController {
    @Autowired
    private ListingService service;

    @GetMapping
    public List<Listing> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Listing create(@RequestBody Listing listing) {
        return service.save(listing);
    }
}