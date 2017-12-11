import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestBlackjack {

    @Test
    public void testBlackjack() {
        for (Suit suit1 : Suit.values()) {
            for (Rank rank1 : Rank.values()) {
                for (Suit suit2 : Suit.values()) {
                    for (Rank rank2 : Rank.values()) {
                        Hand hand = new Hand();
                        hand.addCard(new Card(suit1, rank1));
                        hand.addCard(new Card(suit2, rank2));
                        if (hand.getPointTotal() == 21) {
                            assert(hand.isBlackjack());
                        } else {
                            assert(!hand.isBlackjack());
                        }
                    }
                }
            }
        }
    }
    // @Property public void testBlackjack(Card card1, Card card2) {
    //     Hand hand = new Hand();
    //     hand.addCard(card1);
    //     hand.addCard(card2);
    //     if (hand.getPointTotal() == 21) {
    //         assert(hand.isBlackjack());
    //     }
    // }
}
