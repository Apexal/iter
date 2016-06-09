package com.gmail.thefrankmatranga.entities;

import java.util.ArrayList;

public class Player {
    private String desire;

    static final double START_HEALTH = 100.0;
    static final int START_ARMOR = 20;

    private String name;
    private String description;

    private double health;
    private int armor;

    private boolean alive;

    private ArrayList<String> inventoryIDs;

    public Player(String name, String desire) {
        setName(name);
        setHealth(Player.START_HEALTH);
        setArmor(Player.START_ARMOR);
        setDesire(desire);
        setDescription("The player.");

        inventoryIDs = new ArrayList<String>();
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setDescription(String newDescription) {
        this.description = newDescription;
    }

    public void setHealth(double newHealth) {
        this.health = newHealth;
    }

    public void setArmor(int newArmor) {
        this.armor = newArmor;
    }

    public void setDesire(String newDesire) {
        desire = newDesire;
    }

    public String toString() {
        return name + " (" + description + ") with __ health and __ armor.";
    }
}