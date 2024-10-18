// Item.java
public class Item {
    private final String name; // Item name
    private final double weight; // Item weight
    private final int value; // Item value
    private boolean included; // Inclusion status in a solution

    // Constructor initializes item with name, weight, and value
    public Item(String name, double weight, int value) {
        this.name = name;
        this.weight = weight;
        this.value = value;
        this.included = false; // Default is not included
    }

    // Copy constructor for creating a new Item from an existing one
    public Item(Item other) {
        this.name = other.name;
        this.weight = other.weight;
        this.value = other.value;
        this.included = other.included;
    }

    // Getters and setters for item properties
    public double getWeight() { return weight; }
    public int getValue() { return value; }
    public boolean isIncluded() { return included; }
    public void setIncluded(boolean included) { this.included = included; }

    // String representation of the item
    @Override
    public String toString() {
        return String.format("%s (%.2f lbs, $%d)", name, weight, value);
    }
}
