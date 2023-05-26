package tools;

import lib.models.GenotypePair;

import java.util.Random;

public class Cross {
    public static GenotypePair crossingOperator(GenotypePair pair) {
        Random random = new Random();
        String genotype1 = pair.getGenotypeA();
        String genotype2 = pair.getGenotypeB();
        StringBuilder newGenotype1 = new StringBuilder();
        StringBuilder newGenotype2 = new StringBuilder();

        for (int i = 0; i < genotype1.length(); i++) {
            if (random.nextDouble() < 0.5) {
                newGenotype1.append(genotype1.charAt(i));
                newGenotype2.append(genotype2.charAt(i));
            } else {
                newGenotype1.append(genotype2.charAt(i));
                newGenotype2.append(genotype1.charAt(i));
            }
        }

        return new GenotypePair(newGenotype1.toString(), newGenotype2.toString());
    }
}
