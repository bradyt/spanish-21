import org.junit.Test;
import static org.junit.Assert.*;

public class TestHand {

    @Test
    public void testHand2() {
        Bet bet = new Bet(0);
        bet.addCard("clubs", "ace");
        bet.addCard("clubs", "two");
        assert(bet.isSoft());
    }

    @Test
    public void testHand() {
        Suit suit = Suit.CLUBS;
        Card ace = new Card(suit, Rank.ACE);
        Card two = new Card(suit, Rank.TWO);
        Card nine = new Card(suit, Rank.NINE);
        Card jack = new Card(suit, Rank.JACK);

        checkSoft(true, ace, jack);
        checkSoft(true, ace, two);
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
