class Simulation {

    static float runSimulation(int rounds, Rules rules, Shoe shoe) {

        float totalDeltaMoney = 0;

        for (int i = 0; i < rounds; i++) {
            totalDeltaMoney += Round.playRound(shoe, rules);
        }

        return totalDeltaMoney / rounds;

    }
}
