// GeneticAlgorithm.java
import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.Collections;

public class geneticAlgorithm {
    // Reads item data from a file and returns a list of Item objects
    public static ArrayList<Item> readData(String filename) throws FileNotFoundException {
        ArrayList<Item> items = new ArrayList<>();
        Scanner scanner = new Scanner(new File(filename));
        
        // Parse each line into Item objects
        while (scanner.hasNextLine()) {
            String[] parts = scanner.nextLine().split(",");
            String name = parts[0].trim();
            double weight = Double.parseDouble(parts[1].trim());
            int value = Integer.parseInt(parts[2].trim());
            items.add(new Item(name, weight, value));
        }
        scanner.close();
        return items;
    }

    // Initializes a population of chromosomes based on given items
    public static ArrayList<Chromosome> initializePopulation(ArrayList<Item> items, int populationSize) {
        ArrayList<Chromosome> population = new ArrayList<>();
        
        // Create chromosomes with copies of the items
        for (int i = 0; i < populationSize; i++) {
            population.add(new Chromosome(new ArrayList<>(items)));
        }
        return population;
    }

    public static void main(String[] args) throws FileNotFoundException {
        // Load items and initialize the population
        ArrayList<Item> items = readData("items.txt");
        ArrayList<Chromosome> population = initializePopulation(items, 10);

        // Evolution loop for a specified number of generations
        for (int generation = 0; generation < 20; generation++) {
            ArrayList<Chromosome> nextGeneration = new ArrayList<>(population);

            // Crossover to create new offspring
            for (int i = 0; i < population.size(); i += 2) {
                Chromosome parent1 = population.get(i);
                Chromosome parent2 = population.get(i + 1 < population.size() ? i + 1 : 0);
                Chromosome child = parent1.crossover(parent2);
                nextGeneration.add(child);
            }

            // Mutate a fraction of the next generation
            for (int i = 0; i < nextGeneration.size() / 10; i++) {
                int index = (int) (Math.random() * nextGeneration.size());
                nextGeneration.get(index).mutate();
            }

            // Sort and select the best individuals for the next generation
            Collections.sort(nextGeneration);
            population = new ArrayList<>(nextGeneration.subList(0, 10));
        }

        // Final sorting and output of the best solution found
        Collections.sort(population);
        System.out.println("Best solution found:");
        System.out.println(population.get(0));
    }
}
