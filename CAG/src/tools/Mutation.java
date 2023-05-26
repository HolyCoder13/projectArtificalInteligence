package tools;

import lib.models.GenotypePair;

import java.util.Random;

public class Mutation {
    public static GenotypePair generateMutation(GenotypePair pair, double mutationProbability) {
        Random random = new Random();
        String genotype1 = pair.getGenotypeA();
        String genotype2 = pair.getGenotypeB();
        StringBuilder mutatedGenotype1 = new StringBuilder();
        StringBuilder mutatedGenotype2 = new StringBuilder();

        for (int i = 0; i < genotype1.length(); i++) {
            if (random.nextDouble() < mutationProbability) {
                mutatedGenotype1.append(flipBit(genotype1.charAt(i)));
            } else {
                mutatedGenotype1.append(genotype1.charAt(i));
            }

            if (random.nextDouble() < mutationProbability) {
                mutatedGenotype2.append(flipBit(genotype2.charAt(i)));
            } else {
                mutatedGenotype2.append(genotype2.charAt(i));
            }
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


//package tools;
//
//import jdk.jshell.spi.ExecutionControl;
//
//import javax.management.BadAttributeValueExpException;
//import java.util.Random;
//
//public class Mutation {
//
//    public static Integer generateMutation(Integer fenotype) {
//        throw new RuntimeException();
//    }
//
//    public static Byte generateMutation(Byte fenotype) {
//
//        throw new RuntimeException();
//    }
//
//    public static String generateMutation8(String genotype) {
//        throw new RuntimeException();
//    }
//
//    public static String generateMutation32(String genotype) {
//        throw new RuntimeException();
//    }
//
//    public static String generateMutation(String genotype, int length) {
//        Random random = new Random();
//        int index = random.nextInt(length);
//        char gene = genotype.charAt(index);
//        char mutatedGene = (gene == '0') ? '1' : '0';
//        StringBuilder mutatedGenotype = new StringBuilder(genotype);
//        mutatedGenotype.setCharAt(index, mutatedGene);
//        return mutatedGenotype.toString();
//    }
//
//}
