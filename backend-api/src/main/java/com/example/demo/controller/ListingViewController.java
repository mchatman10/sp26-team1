package com.example.demo.controller;

import com.example.demo.service.ListingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ListingViewController {

    private final ListingService listingService;

    public ListingViewController(ListingService listingService) {
        this.listingService = listingService;
    }

    @GetMapping("/services")
    public String getAllListings(Model model) {
        model.addAttribute("services", listingService.getAllListings());
        return "services";
    }
}