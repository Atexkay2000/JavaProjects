// Chromosome.java
import java.util.ArrayList; // Importing ArrayList for dynamic array functionality
import java.util.Random; // Importing Random for generating random values

public class Chromosome extends ArrayList<Item> implements Comparable<Chromosome> { // Chromosome class extending ArrayList
    private static Random rng = new Random(); // Static Random instance for random operations

    // Default constructor
    public Chromosome() {
        super(); // Call to the parent constructor
    }

    // Constructor that initializes a chromosome with a list of items
    public Chromosome(ArrayList<Item> items) {
        super(); // Call to the parent constructor
        // Create new items with random inclusion status
        for (Item item : items) {
            Item newItem = new Item(item); // Clone the item
            newItem.setIncluded(rng.nextBoolean()); // Randomly include or exclude the item
            this.add(newItem); // Add the new item to this chromosome
        }
    }

    // Method for crossover between two chromosomes to produce a child chromosome
    public Chromosome crossover(Chromosome other) {
        Chromosome child = new Chromosome(); // Create a new child chromosome
        // Select items from either parent randomly
        for (int i = 0; i < this.size(); i++) {
            Item childItem = new Item(rng.nextBoolean() ? this.get(i) : other.get(i)); // Randomly select an item from either parent
            child.add(childItem); // Add the selected item to the child
        }
        return child; // Return the new child chromosome
    }

    // Method to mutate the chromosome with a 10% chance per item
    public void mutate() {
        for (Item item : this) {
            if (rng.nextInt(10) == 0) { // 10% chance of mutation
                item.setIncluded(!item.isIncluded()); // Toggle the item's inclusion status
            }
        }
    }

    // Method to calculate the fitness of the chromosome
    public int getFitness() {
        double totalWeight = 0; // Total weight of included items
        int totalValue = 0; // Total value of included items
        // Iterate through items to calculate total weight and value
        for (Item item : this) {
            if (item.isIncluded()) { // Check if the item is included
                totalWeight += item.getWeight(); // Accumulate weight
                totalValue += item.getValue(); // Accumulate value
            }
        }
        // Return total value if weight limit is not exceeded; otherwise, return 0
        return totalWeight <= 10 ? totalValue : 0;
    }

    // Method to compare chromosomes based on fitness for sorting
    @Override
    public int compareTo(Chromosome other) {
        return Integer.compare(other.getFitness(), this.getFitness()); // Compare fitness values
    }

    // Method to return a string representation of the chromosome
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); // StringBuilder for efficient string concatenation
        for (Item item : this) {
            if (item.isIncluded()) { // Only include items that are included
                sb.append(item.toString()).append("\n"); // Append item details
            }
        }
        sb.append("Fitness: ").append(getFitness()); // Append fitness value
        return sb.toString(); // Return the complete string representation
    }
}
