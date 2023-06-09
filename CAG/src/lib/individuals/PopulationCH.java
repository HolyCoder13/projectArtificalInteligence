package lib.individuals;

import lib.individuals.base.IIndividual;
import solution.Individual;
import tools.FitnessFunction;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

public class PopulationCH implements Individual {
    private String _genotype;
    private Integer _fenotype;
    private Function<Double, Double> _fitnessFunction;

    protected PopulationCH(Integer day, Function<Double, Double> fitnessFunction) {
        _fitnessFunction = fitnessFunction;
        var result = Integer.toBinaryString(day);
        setGenotypeUpdateAll(result);
    }

    @Override
    public int getId() {
        return this.hashCode();
    }


    @Override
    public String getGenotype() {
        return _genotype;
    }

    @Override
    public int getGenotypeLength() {
        return _genotype.length();
    }

    @Override
    public boolean setGenotype(String genotype) {
        return false;
    }


    public boolean setGenotypeUpdateAll(String genotype) {
        if(genotype == null)
            return false;

        if(!genotype.matches("[01]*") || genotype.length() > 8 )
            return false;

        String newGeno = genotype.length() == 8 ? genotype : "0".repeat(8- genotype.length()) + genotype;

        _genotype = newGeno;

        _fenotype = Integer.parseInt(_genotype,2);

        return true;
    }

    @Override
    public Double getFitnessValue() {

        Double argument = (double) _fenotype;

        Double result = this._fitnessFunction.apply(argument);

        return result;
    }

    @Override
    public Individual cloneIndividual() {
        return create(this._fenotype);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("G: ").append(_genotype)
                .append(", F: ").append(_fenotype)
                .append(", Fittness: ").append(getFitnessValue())
                .append(", ID: ").append(getId());
        return builder.toString();
    }

    public static PopulationCH create(Integer day, BiFunction<Double, Double, Double> fitnessFunction) {
        return new PopulationCH(day, (Function<Double, Double>) fitnessFunction);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PopulationCH dayKP = (PopulationCH) o;
        return Objects.equals(_genotype, dayKP._genotype) && Objects.equals(_fenotype, dayKP._fenotype) && Objects.equals(_fitnessFunction, dayKP._fitnessFunction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(_genotype, _fenotype, _fitnessFunction);
    }
}