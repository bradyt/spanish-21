import java.util.*;

class Main {
    public static void main(String[] args) {
        int numOfRounds = (int)Math.pow(10, 5);

        float result1 = Simulation.runSimulation(numOfRounds, Rules.S17, new Shoe(5));
        System.out.printf("For S17  the expected value is: %.4f %n", result1);

        float result2 = Simulation.runSimulation(numOfRounds, Rules.H17REDOUBLE, new Shoe(5));
        System.out.printf("For H17W the expected value is: %.4f %n", result2);

        float result3 = Simulation.runSimulation(numOfRounds, Rules.H17, new Shoe(5));
        System.out.printf("For H17  the expected value is: %.4f %n", result3);
    }
}
