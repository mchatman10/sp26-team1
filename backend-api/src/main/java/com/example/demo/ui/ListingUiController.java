package com.example.demo.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Listing;
import com.example.demo.service.ListingService;

@Controller
@RequestMapping("/listings")
public class ListingUiController {
    @Autowired
    private ListingService service;

    @GetMapping("")
    public String hub(Model model) 
    {
        model.addAttribute("listings", service.getAll());
        return "listing-list";
    }
    @GetMapping("/id/{id}")
    public String getListingById(@PathVariable Long id, Model model)
    {
        model.addAttribute("listing", service.getListingById(id));
        return "listing-Details";
    }

    @GetMapping("/create")
    public String createForm(Model model)
    {
        model.addAttribute("listing", new Listing());
        return "coaching-Post";
    }
    @PostMapping("/create")
    public String createPost( Listing listing) {
        Listing newListing = service.createListing(listing);
        if (newListing != null)
            return "redirect:/listings/id/" + newListing.getSessionId();
        else
            return "redirect:/listings/add?error=true";
    }

    @PostMapping("/update/{id}")
    public String Listing(@PathVariable Long id, Listing updated)
    {
        Listing listing = service.updateListing(id, updated);
        if (listing != null)
        {
            return "redirect:/listings/id/" + listing.getSessionId();
        }
        else
            return "redirect:/listings/update/" + id + "?error=true";
    }
}