package tools;

import lib.models.GenotypePair;

public class OperatorCross3b {
    public static GenotypePair crossingOperator(GenotypePair pair) {
        String genotype1 = pair.getGenotypeA();
        String genotype2 = pair.getGenotypeB();

        int crossoverPoint = genotype1.length() / 2;

        String newGenotype1 = genotype1.substring(0, crossoverPoint) + genotype2.substring(crossoverPoint);
        String newGenotype2 = genotype2.substring(0, crossoverPoint) + genotype1.substring(crossoverPoint);

        return new GenotypePair(newGenotype1, newGenotype2);
    }
}
