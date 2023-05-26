import examples.MapPopulationOpt;

public class Main {
    public static void main(String[] args) {

        try {
            System.out.println("Classic genetic algorithm");


            MapPopulationOpt optymalizacjaPopulacji = new MapPopulationOpt();
            optymalizacjaPopulacji.run();

        } catch (RuntimeException ex) {
            System.out.println("Należy sprawdzić czy operator mutacji i krzyżowania został zaimplementowany!");
        } catch (Exception ex) {
            System.out.println("Wyjątek! " + ex.toString());
        }

    }
}
