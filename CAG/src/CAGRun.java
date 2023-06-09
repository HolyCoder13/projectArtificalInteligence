
    import solution.Individual;
    import tools.FitnessFunction;

    import java.util.*;

    public class CAGRun {
        private List<Individual> population;
        private final int populationSize;
        private final int genotypeLength;
        private final double mutationProbability;

        public CAGRun(int populationSize, int genotypeLength, double mutationProbability) {
            this.populationSize = populationSize;
            this.genotypeLength = genotypeLength;
            this.mutationProbability = mutationProbability;
            this.population = new ArrayList<>();
        }

        public void initializePopulation() {
            for (int i = 0; i < populationSize; i++) {
                Individual individual = createIndividual();
                population.add(individual);
            }
        }

        private Individual createIndividual() {
            StringBuilder genotype = new StringBuilder();
            Random random = new Random();
            for (int i = 0; i < genotypeLength; i++) {
                char gene = (random.nextDouble() < 0.5) ? '0' : '1';
                genotype.append(gene);
            }
            return new Individual(genotype.toString());
        }

        public void run(int numIterations) {
            for (int i = 0; i < numIterations; i++) {
                evaluateFitness();
                List<Individual> newPopulation = new ArrayList<>();
                while (newPopulation.size() < populationSize) {
                    Individual parent1 = selectParent();
                    Individual parent2 = selectParent();
                    Individual offspring = reproduce(parent1, parent2);
                    if (Math.random() < mutationProbability) {
                        mutate(offspring);
                    }
                    newPopulation.add(offspring);
                }
                population = newPopulation;
            }
            evaluateFitness();
            Individual bestIndividual = getBestIndividual();
            System.out.println("Best day: " + bestIndividual.getGenotype());
        }

        private void evaluateFitness() {
            for (Individual individual : population) {
                double fitness = calculateFitness(individual);
                individual.setFitnessValue(fitness);
            }
        }

        private double calculateFitness(Individual individual) {
            String genotype = individual.getGenotype();
            int x = Integer.parseInt(genotype.substring(0, genotype.length() / 2), 2);
            int y = Integer.parseInt(genotype.substring(genotype.length() / 2), 2);
            double fitness = FitnessFunction.populationFunction((double) x, (double) y);
            return fitness;
        }


    }