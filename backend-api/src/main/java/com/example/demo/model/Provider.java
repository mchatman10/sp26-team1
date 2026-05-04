package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "providers")
public class Provider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long providerId;

    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String password;

    private String name;
    private String gameUser;
    private String socials;
    private String bio;

    public Provider()
    {

    }
    public Provider(String ema, String pas, String nam, String gam, String soc, String bi)
    {
        email = ema;
        password = pas;
        name = nam;
        gameUser = gam;
        socials = soc;
        bio = bi;
    }

    public void setProviderId(Long id)
    {
        providerId = id;
    }
    public void setEmail(String ema)
    {
        email = ema;
    }
    public void setPassword(String pas)
    {
        password = pas;
    }
    public void setName(String nam)
    {
        name = nam;
    }
    public void setGameUser(String gam)
    {
        gameUser = gam;
    }
    public void setSocials(String soc)
    {
        socials = soc;
    }
    public void setBio(String bi)
    {
        bio = bi;
    }

    public Long getProviderId()
    {
        return providerId;
    }
    public String getEmail()
    {
        return email;
    }
    public String getPassword()
    {
        return password;
    }
    public String getName()
    {
        return name;
    }
    public String getGameUser()
    {
        return gameUser;
    }
    public String getSocials()
    {
        return socials;
    }
    public String getBio()
    {
        return bio;
    }
}
