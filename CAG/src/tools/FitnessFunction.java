package tools;

public class FitnessFunction {

    public static Double populationFunction(Double x, Double y) {
        return -((475-x)*(475-x))-((500-y)*(500-y))+600000;
    }



    public static Double populationFunction(Double x) {
        return x*x*x - 420*x*x + 43700*x + 100000;
    }
}
