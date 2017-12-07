import java.util.Arrays;
import java.util.ArrayList;

class Bet extends Hand {

    private int bet;
    private Hand hand;
    private int numOfDoublings;

    Bet(int bet) {
        this.bet = bet;
        hand = new Hand();
    }

    void addCard(Card card) {
        hand.addCard(card);
    }

    ArrayList<Card> getCards() {
        return hand;
    }

    boolean isBlackjack() {
        return hand.isBlackjack();
    }

    Hand duplicateHand() {
        Hand newHand = new Hand(bet);
        for (Card card : hand) {
            newHand.addCard(card);
        }
        return newHand;
    }

    int getPointTotal() {
        return hand.getPointTotal();
    }

    int getBetAmount() {
        return bet;
    }
}
