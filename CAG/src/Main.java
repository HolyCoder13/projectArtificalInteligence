import examples.DayOptimizationExample;
import solution.Individual;
import tools.FitnessFunction;
import tools.Mutation;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        try {
            System.out.println("Classic genetic algorithm");

            // Inicjalizacja parametrów
            int populationSize = 100;
            int genotypeLength = 10; // Długość genotypu dla przykładu DayOptimizationExample
            double mutationProbability = 0.01;

            // Inicjalizacja populacji
            CAGRun cagRun = new CAGRun(populationSize, genotypeLength, mutationProbability);
            cagRun.initializePopulation();

            // Uruchomienie algorytmu genetycznego
            int numIterations = 100;
            cagRun.run(numIterations);

        } catch (RuntimeException ex) {
            System.out.println("Należy sprawdzić czy operator mutacji i krzyżowania został zaimplementowany!");
        } catch (Exception ex) {
            System.out.println("Wyjątek! " + ex.toString());
        }

    }
}
