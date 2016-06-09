package com.gmail.thefrankmatranga.entities;

import com.gmail.thefrankmatranga.items.InventoryManager;

public class Player {
    static final double START_HEALTH = 100.0;
    static final int START_ARMOR = 20;
    private String desire;
    // Allows these attributes to be changed during the game
    private String name;
    private String description;

    private double health;
    private int armor;

    private boolean alive;

    private InventoryManager inventory;

    public Player(String name, String desire) {
        setName(name);
        setHealth(Player.START_HEALTH);
        setArmor(Player.START_ARMOR);
        setDesire(desire);
        setDescription("You");
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