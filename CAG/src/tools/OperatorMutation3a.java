package tools;

import lib.models.GenotypePair;

import java.util.Random;

public class OperatorMutation3a {
    public static GenotypePair generateMutation(GenotypePair pair, double mutationProbability) {
        Random random = new Random();
        String genotype1 = pair.getGenotypeA();
        String genotype2 = pair.getGenotypeB();
        StringBuilder mutatedGenotype1 = new StringBuilder(genotype1);
        StringBuilder mutatedGenotype2 = new StringBuilder(genotype2);

        if (random.nextDouble() < mutationProbability) {
            int index = random.nextInt(genotype1.length());
            mutatedGenotype1.setCharAt(index, flipBit(genotype1.charAt(index)));
        }

        if (random.nextDouble() < mutationProbability) {
            int index = random.nextInt(genotype2.length());
            mutatedGenotype2.setCharAt(index, flipBit(genotype2.charAt(index)));
        }

        return new GenotypePair(mutatedGenotype1.toString(), mutatedGenotype2.toString());
    }

    private static char flipBit(char bit) {
        if (bit == '0') {
            return '1';
        } else {
            return '0';
        }
    }
}
