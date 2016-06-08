public class Item {
    private static int itemCount = 0;
    
    private final String id;
    private final String name;
    private final String description;
    
    public Item(String id, String name, String description) {
        Item.itemCount++;
        
        this.id = id;
        this.name = name;
        this.description = description;
    }
    
    public String toString() {
        return this.name + ": " + this.description;
    }
}