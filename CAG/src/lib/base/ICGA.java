package lib.base;

import lib.individuals.base.IIndividual;

public interface ICGA {
    IIndividual[] findBest();
    boolean isStopConditionSatisfied();
    int numberOfIndividualsConditionSatisfied();
    void generateNextPopulation();
    boolean doMainStep();
    IIndividual[] getPopulation();
}
