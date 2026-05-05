package com.example.demo.model;

import java.util.*;
import jakarta.persistence.*;

@Entity
@Table(name = "listings")
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionId;

    @Column (nullable = false)
    private Long coachId;
    
    @OneToMany(mappedBy = "listing", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Review> reviews;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Games game;

    @Column(nullable = false)
    private String experience;

    private String mainC;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private String sessionType;

    @Transient
    private boolean booked;

    public boolean isBooked() {
        return booked;
    }

    public void setBooked(boolean booked) {
        this.booked = booked;
    }

    private String bio;

    public Listing() {

    }
    public Listing(Long id, Games gam, String expe, String mac, Double pri, String sess, String bi)
    {
        coachId = id;

    public Listing(Games gam, String expe, String mac, Double pri, String sess, String bi) {
        game = gam;
        experience = expe;
        mainC = mac;
        price = pri;
        sessionType = sess;
        bio = bi;

    }

    public void setSessionId(Long ID) {
        sessionId = ID;
    }
    public void setCoachId(Long ID)
    {
        coachId = ID;
    }
    public void setGame(Games gam)
    {

    public void setGame(Games gam) {
        game = gam;
    }

    public void setExperience(String expe) {
        experience = expe;
    }

    public void setMainC(String mac) {
        mainC = mac;
    }

    public void setPrice(Double pri) {
        price = pri;
    }

    public void setSessionType(String sess) {
        sessionType = sess;
    }

    public void setBio(String bi) {
        bio = bi;
    }

    public Long getSessionId() {
        return sessionId;
    }
    public Long getCoachId()
    {
        return coachId;
    }
    public Games getGame()
    {

    public Games getGame() {
        return game;
    }

    public String getExperience() {
        return experience;
    }

    public String getMainC() {
        return mainC;
    }

    public Double getPrice() {
        return price;
    }

    public String getSessionType() {
        return sessionType;
    }

    public String getBio() {
        return bio;
    }

    @OneToMany(mappedBy = "listing", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private java.util.List<Review> reviews;

    @Transient
    private java.util.List<Review> visibleReviews;

    public java.util.List<Review> getVisibleReviews() {
        return visibleReviews != null ? visibleReviews : reviews;
    }

    public void setVisibleReviews(java.util.List<Review> visibleReviews) {
        this.visibleReviews = visibleReviews;
    }
}
