package com.example.demo.repository;

import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByListingSessionId(Long sessionId);
}