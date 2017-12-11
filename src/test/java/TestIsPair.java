import org.junit.Test;
import static org.junit.Assert.*;

public class TestIsPair {
    @Test
    public void testIsPair() {
        for (Suit suit1 : Suit.values()) {
            for (Suit suit2 : Suit.values()) {
                for (Rank rank1 : Rank.values()) {
                    Hand hand = new Hand();
                    hand.addCard(new Card(suit1, rank1));
                    hand.addCard(new Card(suit2, rank1));
                    assert(hand.isPair());
                }
            }
        }
    }
}
