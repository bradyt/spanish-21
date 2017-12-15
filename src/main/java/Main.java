class Main {
    public static void main(String[] args) {
        float result1 = Simulation.runSimulation(10000, Rules.S17, new Shoe(5));
        System.out.println("For S17 the expected value is: " + result1);

        float result2 = Simulation.runSimulation(10000, Rules.H17, new Shoe(5));
        System.out.println("For H17 the expected value is: " + result2);

        // float result3 = Simulation.runSimulation(40000, Rules.H17REDOUBLE, new Shoe(5));
        // System.out.println("For H17REDOUBLE the expected value is: " + result3);
    }
}
