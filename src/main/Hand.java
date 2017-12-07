import java.util.Arrays;
import java.util.ArrayList;

class Hand {

    private ArrayList<Card> hand;
    private boolean soft;

    Hand () {
        hand = new ArrayList<Card>();
    }

    void addCard(Card card) {
        hand.add(card);
    }

    int getPointTotal() {
        int aces = 0;
        int ptTot = 0;
        for (Card card : hand) {
            if (card.equals(Rank.ACE)) {
                aces++;
            }
            ptTot = ptTot + card.point;
        }
        while (ptTot > 21 && aces > 0) {
            ptTot -= 10;
            aces--;
        }
        return ptTot;
    }

    ArrayList<Card> getCards() {
        return hand;
    }

    boolean isBlackjack() {
        return (hand.size() == 2 && getPointTotal() == 21);
    }

    // Hand duplicateHand() {
    //     Hand newHand = new Hand(bet);
    //     for (Card card : hand) {
    //         newHand.addCard(card);
    //     }
    //     return newHand;
    // }
}
