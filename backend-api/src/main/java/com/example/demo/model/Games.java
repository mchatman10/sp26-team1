package com.example.demo.model;

public enum Games 
{
    OG("Super Smash Bros."),
    Sixty("Super Smash Bros. 64"),
    Melee("Super Smash Bros. Melee"),
    Brawl("Super Smash Bros. Brawl"),
    For("Super Smash Bros. 4"),
    Ult("Super Smash Bros. Ultimate");

    public final String gameName;

    private Games(String game)
    {
        this.gameName = game;
    }
}
