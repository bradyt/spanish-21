import org.junit.Test;
import static org.junit.Assert.*;

public class TestIsSoft {

    @Test
    public void testIsSoft() {
        Suit suit = Suit.CLUBS;
        Card ace = new Card(suit, Rank.ACE);
        Card two = new Card(suit, Rank.TWO);
        Card nine = new Card(suit, Rank.NINE);
        Card jack = new Card(suit, Rank.JACK);

        checkSoft(true, ace, jack);
        checkSoft(false, ace, jack, two);
    }

    public void checkSoft(boolean checkIsSoft, Card... cards) {
        Hand hand = new Hand();
        for (Card card : cards) {
            hand.addCard(card);
        }
        if (checkIsSoft) {
            assert(hand.isSoft());
        } else {
            assert(!hand.isSoft());
        }
    }
        
}
