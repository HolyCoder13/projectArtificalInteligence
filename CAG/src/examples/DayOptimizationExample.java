package examples;

import lib.CGA;
import lib.base.ICGA;
import lib.individuals.PopulationCH;
import lib.individuals.base.IIndividual;
import tools.Cross;
import tools.Mutation;
import tools.Tool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DayOptimizationExample {
    public static void run() {

        // 1. Ustawienie liczności populacji
        int n = 32;

        // 2. wygenerowanie populacji początkowej
        List<IIndividual> list = new ArrayList<IIndividual>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            var result = PopulationCH.create(random.nextInt(256)); //rozważamy dni 0-255
            list.add(  result  );
        }
        IIndividual[] initPopulation = Tool.CastListToArray(list);

        // 3. Parametry algorytmu. Wybrane w drodze eksperymentu:
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
                Mutation::generateMutation,
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
