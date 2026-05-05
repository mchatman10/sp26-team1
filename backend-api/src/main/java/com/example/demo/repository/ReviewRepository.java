package com.example.demo.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByListingSessionId(Long sessionId);
    @Query("""
            select distinct r
            from Review r
            where (r.listing is not null and r.listing.sessionId = :listingId)
               or r.listingSessionId = :listingId
            """)
    List<Review> findForListing(@Param("listingId") Long listingId);
}

