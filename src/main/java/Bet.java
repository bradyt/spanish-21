// should add a method to duplicate a hand/bet
class Bet extends Hand {

    private int bet;
    private int numOfDoublings;

    Bet(int bet) {
        this.bet = bet;
    }

    int getBetAmount() {
        return bet;
    }
}
