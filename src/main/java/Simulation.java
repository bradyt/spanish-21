class Simulation {
    static float runSimulation(int rounds, Rules rules, Shoe shoe) {
        shoe.shuffle();
        double totalDeltaMoney = 0;
        float bet = 5;
        Strategy strategy = new Strategy(rules);
        for (int i = 0; i < rounds; i++) {
            float deltaMoney = Round.playRound(shoe, rules, strategy, bet);
            totalDeltaMoney += deltaMoney;
        }
        return (float)totalDeltaMoney / rounds / bet;
    }
}
