import java.util.ArrayList;

class Player {

    private float money;
    private ArrayList<Bet> stoodBets;
    private ArrayList<Bet> actionableBets;
    private int numOfSplits;

    Player(float money) {
        this.money = money;
        stoodBets = new ArrayList<Bet>();
        actionableBets = new ArrayList<Bet>();
    }

    float getMoney() {
        return money;
    }

    void addBet(float bet) {
        actionableBets.add(new Bet(bet));
    }

    boolean hasActionableBets() {
        return !actionableBets.isEmpty();
    }

    void addCard(Card card) {
        actionableBets.get(0).addCard(card);
    }

    int getPointTotal() {
        return actionableBets.get(0).getPointTotal();
    }

    void increaseMoneyByBet(float payout) {
        System.out.println(payout);
        float delta = payout * actionableBets.get(0).getBetAmount();
        System.out.println(delta);
        money += delta;
    }

    void popBet() {
        actionableBets.remove(0);
    }

    void printMoney() {
        System.out.println(money);
    }
}
