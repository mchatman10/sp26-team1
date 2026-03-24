package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Listing;

public interface ListingRepository extends JpaRepository<Listing, Long> {
}