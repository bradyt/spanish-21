import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Deck {

    List<Card> deck;

    Deck(int numOfDecks) {
        deck = new ArrayList<Card>();
        for (int i = 0; i < numOfDecks; i++) {
            for (Suit suit : Suit.values()) {
                for (Rank rank : Rank.values()) {
                    deck.add(new Card(suit, rank));
                }
            }
        }
    }

    void shuffle() {
        Collections.shuffle(deck);
    }

    Card dealCard() {
        return deck.remove(0);
    }

}
