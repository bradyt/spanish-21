class Simulation {
    static float runSimulation(int rounds, Rules rules, Shoe shoe) {
        shoe.shuffle();
        float totalDeltaMoney = 0;
        float bet = 5;
        Strategy strategy = new Strategy(rules);
        for (int i = 0; i < rounds; i++) {
            totalDeltaMoney += Round.playRound(shoe, rules, strategy, bet);
        }
        return totalDeltaMoney / rounds / bet;
    }
}
