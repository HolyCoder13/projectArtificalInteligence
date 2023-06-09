package tools;

import jdk.jshell.spi.ExecutionControl;

import javax.management.BadAttributeValueExpException;
import java.util.Random;

public class Mutation {

    public static Integer generateMutation(Integer fenotype) {
        throw new RuntimeException();
    }

    public static Byte generateMutation(Byte fenotype) {

        throw new RuntimeException();
    }

    public static String generateMutation8(String genotype) {
        throw new RuntimeException();
    }

    public static String generateMutation32(String genotype) {
        throw new RuntimeException();
    }

    public static String generateMutation(String genotype, int length) {
        Random random = new Random();
        int index = random.nextInt(length);
        char gene = genotype.charAt(index);
        char mutatedGene = (gene == '0') ? '1' : '0';
        StringBuilder mutatedGenotype = new StringBuilder(genotype);
        mutatedGenotype.setCharAt(index, mutatedGene);
        return mutatedGenotype.toString();
    }

}
