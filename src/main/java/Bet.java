// should add a method to duplicate a hand/bet
class Bet extends Hand {

    private float bet;
    private int numOfDoublings;

    Bet(float bet) {
        this.bet = bet;
        numOfDoublings = 0;
    }

    float getBetAmount() {
        return bet;
    }

    boolean hasDoubled() {
        return numOfDoublings > 0;
    }

    int getNumOfDoublings() {
        return numOfDoublings;
    }

    void incrementNumOfDoublings() {
        numOfDoublings++;
    }
}
