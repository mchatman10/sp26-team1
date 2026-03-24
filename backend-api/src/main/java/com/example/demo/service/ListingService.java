package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Listing;
import com.example.demo.repository.ListingRepository;
import java.util.List;

@Service
public class ListingService {

    @Autowired
    private ListingRepository repo;

    public List<Listing> getAll() {
        return repo.findAll();
    }

    public Listing save(Listing listing) {
        return repo.save(listing);
    }
    
    public Listing getListingById(long id)
    {
        return repo.findById(id).orElse(null);
    }
}