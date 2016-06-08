package com.gmail.thefrankmatranga.rooms;

import com.gmail.thefrankmatranga.items.*;

public class Room {
    
    private String description;
    
    private Item[] items;
    
    public Room() {
        
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String newDescription) {
        description = newDescription;
    }
}