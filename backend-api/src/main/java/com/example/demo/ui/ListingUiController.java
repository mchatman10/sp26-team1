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
import com.example.demo.service.ProviderService;

@Controller
@RequestMapping("/listings")
public class ListingUiController {
    @Autowired
    private ListingService service;
    @Autowired
    private ProviderService pservice;

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
        model.addAttribute("provider", pservice.getProviderById(service.getListingById(id).getCoachId()));
        return "listing-Details";
    }

    @GetMapping("/create/{providerId}")
    public String createForm(@PathVariable("providerId") Long providerId, Model model)
    {
        model.addAttribute("listing", new Listing());
        model.addAttribute("provider", pservice.getProviderById(providerId));
        return "coaching-Post";
    }
    @PostMapping("/create/{providerId}")
    public String createPost(Listing listing, @PathVariable("providerId") Long providerId)
    {
        listing.setCoachId(providerId);
        Listing newListing = service.createListing(listing);
        if (newListing != null)
            return "redirect:/listings/id/" + newListing.getSessionId();
            else
            return "redirect:/listings/create/" + providerId + "add?error=true";
    }

    @PostMapping("/update/{id}")
    public String Listing(@PathVariable Long id, Listing updated)
    {
        Listing listing = service.updateListing(id, updated);
        if (listing != null)
        {
            return "redirect:/provider/dashboard/" + listing.getCoachId();
        }
        else
            return "redirect:/listings/update/" + id + "?error=true";
    }

    @GetMapping("/delete/{id}")
    public String deleteCharacter(@PathVariable("id") Long listingId, Model model)
    {
        Long sev = service.getListingById(listingId).getCoachId();
        service.deleteListing(listingId);
        return "redirect:/provider/dashboard/" + sev;
    }
}