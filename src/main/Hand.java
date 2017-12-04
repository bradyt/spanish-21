import java.util.Arrays;
import java.util.ArrayList;

class Hand {

    ArrayList<Card> hand;

    Hand () {
        hand = new ArrayList<Card>();
    }

    void addCard(Card card) {
        hand.add(card);
    }

    int getValue() {
        int aces = 0;
        int value = 0;
        for (Card card : hand) {
            if (card.isAce()) {
                aces++;
            }
            value = value + card.point;
        }
        while (value > 21 && aces > 0) {
            value -= 10;
            aces--;
        }
        return value;
    }

    ArrayList<Card> getCards() {
        return hand;
    }

}
