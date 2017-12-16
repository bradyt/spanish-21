import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Shoe {

    private int numOfDecks;
    private List<Card> shoe;

    Shoe(int numOfDecks) {
        this.numOfDecks = numOfDecks;
        makeDeck();
    }

    void makeDeck() {
        shoe = new ArrayList<Card>();
        for (int i = 0; i < numOfDecks; i++) {
            for (Suit suit : Suit.values()) {
                for (Rank rank : Rank.values()) {
                    shoe.add(new Card(suit, rank));
                }
            }
        }
    }


    void addCardByString(String suit, String rank) {
        Suit s = Suit.valueOf(suit.toUpperCase());
        Rank r = Rank.valueOf(rank.toUpperCase());
        shoe.add(new Card(s, r));
    }

    void shuffle() {
        Collections.shuffle(shoe);
    }

    Card dealCard() {
        if (shoe.isEmpty()) {
            makeDeck();
            shuffle();
        }
        return shoe.remove(0);
    }

}
