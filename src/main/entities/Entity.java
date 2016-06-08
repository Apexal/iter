package entities;

public class Entity{
    
    static final double START_HEALTH = 100;
    
    private String name;
    private String description;
    
    private double health;
    private int armor;
    
    private boolean alive;
    
    public Entity(String name) {
        this.name = name;
        this.health = Entity.START_HEALTH;
        this.description = "An unknown entity.";
        this.alive = true;
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
    
    public String toString() {
        return name + " (" + description + ") with __ health and __ armor.";
    }
}