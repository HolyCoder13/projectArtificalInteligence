
package examples;

import lib.CGA;
import lib.base.ICGA;
import lib.individuals.base.IIndividual;
import solution.IdMap;
import solution.Individual;
import tools.Cross;
import tools.Mutation;
import tools.Tool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MapPopulationOpt {
    public static void run() {

        int n = 36;


        List<Individual> list = new ArrayList<Individual>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            var result = IdMap.create(random.nextInt(256)); //rozważamy dni 0-255
            list.add((Individual) result);
        }
        IIndividual[] initPopulation = (IIndividual[]) Tool.CastListToArray(list);

        double maximalDifference = 100; // maksymalna różnica z najlepszym osobnikiem (zbiorem najlepszych)
        double populationCheckCeofficient = 0.5; // procent populacji, który ma spełniać warunek porównania
        double mutationProbability = 0.15;
        double crossProbability = 0.5;
        // Wartości te mają wpływ na warunek stopu. Sprawdzamy dla każdej populacji
        // czy populationCheckCeofficient*100% osobników ma taką własność, że :
        // |najlepszyosobnik - osobnik | <= maximalDifference

        // 4. Tworzenie instancji algorytmu
        ICGA algorithm = new CGA(
                initPopulation,
                Mutation::generateMutation;
                Cross::crossingOpeator,
                maximalDifference,
                populationCheckCeofficient,
                mutationProbability,
                crossProbability) ;

        // 5. Wykonanie algorytmu
        int numberOfGenerations = 0;
        while (algorithm.doMainStep()) {
            numberOfGenerations++;

            System.out.println( String.format("Generacja %d, OK/ALL : %d/%d",numberOfGenerations, algorithm.numberOfIndividualsConditionSatisfied() ,algorithm.getPopulation().length ) );
        }

        // 6. Podsumowanie
        System.out.println("\nPopulacja końcowa:");
        for (var item : algorithm.getPopulation()) {
            System.out.println(item);
        }

        System.out.println("\nGrupa maksymalnych rozwiązań: ");
        var theBestOfTheBest = algorithm.findBest();
        for (var item : theBestOfTheBest) {
            System.out.println(item);
        }

        System.out.println("\nOstateczna odpowiedź: ");
        System.out.println( theBestOfTheBest[0].toString() );

    }
}

//package examples;
//
//import lib.CGA;
//import lib.base.ICGA;
//import lib.individuals.base.IIndividual;
//import lib.individuals.PopulationCH;
//import solution.IdMap;
//import solution.Individual;
//import tools.Cross;
//import tools.Mutation;
//import tools.Tool;
//import tools.FitnessFunction;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//public class MapPopulationOpt {
//    public static void run() {
//        // 1. Ustawienie liczności populacji
//        int populationSize = 36;
//
//        // 2. Generowanie populacji początkowej
//        List<Individual> initialPopulation = generateInitialPopulation(populationSize);
//
//        // 3. Parametry algorytmu
//        double maximalDifference = 100; // maksymalna różnica z najlepszym osobnikiem (zbiorem najlepszych)
//        double populationCheckCoefficient = 0.7; // procent populacji, który ma spełniać warunek porównania
//        double mutationProbability = 0.1;
//        double crossProbability = 0.5;
//         Random rd = new Random();
//
//        List<Individual> convertedPopulation = new ArrayList<>();
//        for (IdMap idMap : initialPopulation) {
//            Individual individual = new Individual(idMap.getX(), idMap.getY(), idMap.getFitness());
//            convertedPopulation.add(individual);
//        }
//
//        ICGA algorithm = new CGA(
//                convertedPopulation.toArray(new Individual[convertedPopulation.size()]),
//                Mutation::generateMutation,
//                Cross::crossingOperator,
//                maximalDifference,
//                populationCheckCoefficient,
//                mutationProbability,
//                crossProbability
//        );
//
//
//
//
//
//        int numberOfGenerations = 5;
//        while (algorithm.doMainStep()) {
//            numberOfGenerations++;
//            System.out.println(String.format("Generacja %d, OK/ALL: %d/%d", numberOfGenerations, algorithm.numberOfIndividualsConditionSatisfied(), algorithm.getPopulation().length));
//        }
//        System.out.println("\nPopulacja ostateczna (końcowa):");
//        for (var item : algorithm.getPopulation()) {
//            System.out.println(item);
//        }
//
//        System.out.println("\nGrupa wyników o maksymalnej populacji: ");
//        var theBestOfTheBest = algorithm.findBest();
//        for (var item : theBestOfTheBest) {
//            System.out.println(item);
//        }
//
//        System.out.println("\nFinalna odpowiedź: ");
//        System.out.println(theBestOfTheBest[0].toString());
//    }
//
//    private static List<Individual> generateInitialPopulation(int populationSize) {
//        List<Individual> population = new ArrayList<>();
//        Random random = new Random();
//        for (int i = 0; i < populationSize; i++) {
//            int x = random.nextInt(100); // przykładowe zakresy dla współrzędnych x i y
//            int y = random.nextInt(100);
//            double fitness = FitnessFunction.populationFunction((double) x, (double) y); // obliczenie wartości funkcji przystosowania
//            population.add(new IdMap(x, y, fitness));
//        }
//        return population;
//    }
//
//}
