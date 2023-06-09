package solution;

import java.util.Comparator;

public interface Individual {
    int getId();

    String getGenotype();

    int getGenotypeLength();

    boolean setGenotype(String genotype);

    Double getFitnessValue();

    Individual cloneIndividual();

    public static Comparator<Individual> compare = (Individual a, Individual b) -> {
        if (a.getFitnessValue() < b.getFitnessValue()) return 1;
        else if (a.getFitnessValue() > b.getFitnessValue()) return -1;
        else return 0;
    };
}
