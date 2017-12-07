import java.util.ArrayList;

class Player {

    private int money;
    private ArrayList<Bet> stoodBets;
    private ArrayList<Bet> actionableBets;
    private int numOfSplits;

    Player(int money) {
        this.money = money;
        stoodBets = new ArrayList<Bet>();
        actionableBets = new ArrayList<Bet>();
    }

    void addBet(int bet) {
        actionableBets.add(new Bet(bet));
    }

    boolean hasActionableBets() {
        return !actionableBets.isEmpty();
    }

    void addCard(Card card) {
        actionableBets.get(0).addCard(card);
    }

    int getValue() {
        return actionableBets.get(0).getPointTotal();
    }

    void increaseMoneyByBet(float payout) {
        money += payout * actionableBets.get(0).getBetAmount();
    }

    void popBet() {
        actionableBets.remove(0);
    }
}
