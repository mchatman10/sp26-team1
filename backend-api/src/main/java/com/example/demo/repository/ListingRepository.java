package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Listing;
import com.example.demo.model.Games;
import java.util.*;

@Repository
public interface ListingRepository extends JpaRepository<Listing, Long> {

    List<Listing> findByGame(Games game);

    @Query(value = "SELECT s.* FROM listings s WHERE s.price >= ?1", nativeQuery = true)
    List<Listing> findByPrice( Double price);

    Listing findByBio(String bio);
}