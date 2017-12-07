import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Shoe {

    private List<Card> shoe;

    Shoe(int numOfDecks) {
        shoe = new ArrayList<Card>();
        for (int i = 0; i < numOfDecks; i++) {
            for (Suit suit : Suit.values()) {
                for (Rank rank : Rank.values()) {
                    shoe.add(new Card(suit, rank));
                }
            }
        }
        // shoe.shuffle()
    }

    void shuffle() {
        Collections.shuffle(shoe);
    }

    Card dealCard() {
        return shoe.remove(0);
    }

}