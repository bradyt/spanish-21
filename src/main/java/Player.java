import java.util.ArrayList;

class Player {

    private float money;
    private Bet currentBet;
    private ArrayList<Bet> bets;
    // private ArrayList<Bet> stoodBets;
    // private ArrayList<Bet> actionableBets;
    private int numOfSplits;

    Player(float money) {
        this.money = money;
        bets = new ArrayList<Bet>();
        // stoodBets = new ArrayList<Bet>();
        // actionableBets = new ArrayList<Bet>();
    }

    // Bet getCurrentBet() {
    //     return currentBet;
    // }
       
    float getMoney() {
        return money;
    }

    void addBet(float bet) {
        bets.add(new Bet(bet));
        // actionableBets.add(new Bet(bet));
    }

    void hit(Card card) {
    }

    void stand() {
    }

    void doubleDown(Card card) {
    }

    void surrender() {
    }

    void split() {
    }

    boolean hasActionableBets() {
        for (Bet bet : bets) {
            if (bet.getState() == Bet.State.ACTIONABLE) {
                currentBet = bet;
                return true;
            }
        }
        return false;
        // return !actionableBets.isEmpty();
    }

    void addCard(Card card) {
        currentBet.addCard(card);
    }

    int getPointTotal() {
        return currentBet.getPointTotal();
    }

    void increaseMoneyByBet(float payout) {
        System.out.println(payout);
        float delta = payout * currentBet.getBetAmount();
        System.out.println(delta);
        money += delta;
    }

    // void popBet() {
    //     actionableBets.remove(0);
    // }

    void printMoney() {
        System.out.println(money);
    }
}
