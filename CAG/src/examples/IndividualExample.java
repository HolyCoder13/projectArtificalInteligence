package examples;

import lib.individuals.PopulationCH;
import lib.individuals.base.IIndividual;

import java.util.ArrayList;
import java.util.Random;

public class IndividualExample {
    public static void run() {

        PopulationCH individual = PopulationCH.create(3);

        System.out.println(individual);

        System.out.println("After genotype update");

        var result1 = individual.setGenotypeUpdateAll("11111111");
        if( !result1 )
            System.out.println("Problem przy ustawianiu osobnika na podstawie genotypu");

        System.out.println(individual);

        var cloneIndividual = individual.cloneIndividual();

        var result2 = cloneIndividual.setGenotypeUpdateAll("10101010");
        if( !result2 )
            System.out.println("Problem przy ustawianiu osobnika na podstawie genotypu");

        System.out.println("Clone: " + cloneIndividual);
        System.out.println("Original: " + individual);

        Random rand = new Random();
        var cloneArmy = new ArrayList<IIndividual>();
        for (int i = 0; i < 66; i++) {
            var clone44 = individual.cloneIndividual();
            var result3 = clone44.setGenotypeUpdateAll( Integer.toBinaryString(rand.nextInt(256)) );
            if( !result3 )
                System.out.println("Problem przy ustawianiu osobnika na podstawie genotypu");

            cloneArmy.add(clone44);
        }

        System.out.println();
        System.out.println("Clone army: ");
        for (var indiv : cloneArmy) {
            System.out.println(indiv);
        }
    }
}
