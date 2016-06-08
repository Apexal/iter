package com.gmail.thefrankmatranga.entities;

public class Player extends Entity{
    private String desire;

    public Player(String name, String desire) {
        super(name);
        setDesire(desire);
        setDescription("The player.");
    }

    public void setDesire(String newDesire) {
        desire = newDesire;
    }
}