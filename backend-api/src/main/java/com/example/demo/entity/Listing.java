package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "listing")
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sessionId;

    @Column(nullable = false)
    private Games game;

    @Column(nullable = false)
    private String experience;

    @Column
    private String mainC;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private String sessionType;

    @Column
    private String bio;

    public Listing()
    {

    }
    public Listing(Games gam, String expe, String mac, double pri, String sess, String bi)
    {
        game = gam;
        experience = expe;
        mainC = mac;
        price = pri;
        sessionType = sess;
        bio = bi;

    }

    public void setID(Long ID)
    {
        sessionId = ID;
    }
    public void setGame(Games gam)
    {
        game = gam;
    }
    public void setExperience(String expe)
    {
        experience = expe;
    }
    public void setMainC(String mac)
    {
        mainC = mac;
    }
    public void setPrice(double pri)
    {
        price = pri;
    }
    public void setSessionType(String sess)
    {
        sessionType = sess;
    }
    public void setBio(String bi)
    {
        bio = bi;
    }

    public Long getID()
    {
        return sessionId;
    }
    public Games getGame()
    {
        return game;
    }
    public String getExperience()
    {
        return experience;
    }
    public String getMainC()
    {
        return mainC;
    }
    public double getPrice()
    {
        return price;
    }
    public String getSessionType()
    {
        return sessionType;
    }
    public String getBio()
    {
        return bio;
    }
}