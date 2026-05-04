package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Games;
import com.example.demo.model.Listing;
import com.example.demo.repository.ListingRepository;
import java.util.List;

@Service
public class ListingService 
{
    @Autowired
    private ListingRepository repo;
    //private static final String UPLOAD_DIR = "src/main/resources/static/pictures/";

    public ListingService(ListingRepository re)
    {
        repo = re;
    }
    public List<Listing> getAllListings() {
        return repo.findAll();
    }

    public Listing createListing(Listing listing)
     {
        return repo.save(listing);
    }

    public List<Listing> getAll()
    {
        return repo.findAll();
    }
    
    public Listing getListingById(Long id)
    {
        return repo.findById(id).orElse(null);
    }
    public List<Listing> getListingByCoachId(long id)
    {
        return repo.findByCoachId(id);
    }

    public List<Listing> getListingByGame(Games game)
    {
        return repo.findByGame(game);
    }

    public Listing updateListing(long id, Listing post)
    {
        return repo.findById(id)
        .map(listing -> {
            listing.setBio(post.getBio());
            listing.setExperience(post.getExperience());
            listing.setGame(post.getGame());
            listing.setMainC(post.getMainC());
            listing.setPrice(post.getPrice());
            listing.setSessionType(post.getSessionType());
            return repo.save(listing);
        })
        .orElse(null);
    }
    public void deleteListing(Long id)
    {
        repo.deleteById(id);
    }
}
