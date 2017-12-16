import org.junit.Test;
import static org.junit.Assert.*;

public class TestPayout {

    public void skeleton(int upcard,
                         int dealersPointTotal,
                         boolean hasSplit,
                         boolean hasDoubled,
                         float bet,
                         float expectedPayout,
                         Hand.State state,
                         Card... cards) {
        Hand hand = new Hand(bet);
        for (Card card : cards) {
            hand.addCard(card);
        }
        hand.setState(state);
        if (hasDoubled) {hand.incrementNumOfDoublings();}
        float payout = Payout.calculatePayout(upcard,
                                              dealersPointTotal,
                                              hand,
                                              hasSplit);
        assertEquals(expectedPayout, payout, .001);
    }
        
    @Test
    public void testCalculatePayout() {
        skeleton(0, 0, false, false, 5, -5, Hand.State.BUSTED);
        skeleton(0, 0, false, false, 5, -5, Hand.State.LOSTTODEALERBLACKJACK);
        skeleton(0, 0, false, false, 5, (float)7.5, Hand.State.BLACKJACK);
        skeleton(0, 0, false, false, 5, (float)-2.5, Hand.State.SURRENDERED);

        skeleton(7, 21, false, true, 5, 5, Hand.State.STAND,
                 new Card(Suit.SPADES, Rank.SEVEN),
                 new Card(Suit.SPADES, Rank.SEVEN),
                 new Card(Suit.SPADES, Rank.SEVEN));
 
        skeleton(7, 21, false, false, 5, 1000, Hand.State.STAND,
                 new Card(Suit.SPADES, Rank.SEVEN),
                 new Card(Suit.SPADES, Rank.SEVEN),
                 new Card(Suit.SPADES, Rank.SEVEN));
 
        skeleton(7, 18, false, false, 25, 5000, Hand.State.STAND,
                 new Card(Suit.SPADES, Rank.SEVEN),
                 new Card(Suit.SPADES, Rank.SEVEN),
                 new Card(Suit.SPADES, Rank.SEVEN));

        skeleton(11, 21, true, false, 5, 15, Hand.State.STAND,
                 new Card(Suit.SPADES, Rank.SEVEN),
                 new Card(Suit.SPADES, Rank.SEVEN),
                 new Card(Suit.SPADES, Rank.SEVEN));

        skeleton(11, 21, true, false, 5, 10, Hand.State.STAND,
                 new Card(Suit.CLUBS, Rank.SEVEN),
                 new Card(Suit.CLUBS, Rank.SEVEN),
                 new Card(Suit.CLUBS, Rank.SEVEN));

        skeleton(11, 21, true, false, 5, (float)7.5, Hand.State.STAND,
                 new Card(Suit.CLUBS, Rank.SEVEN),
                 new Card(Suit.CLUBS, Rank.SEVEN),
                 new Card(Suit.HEARTS, Rank.SEVEN));

        skeleton(11, 21, true, false, 5, 15, Hand.State.STAND,
                 new Card(Suit.SPADES, Rank.SIX),
                 new Card(Suit.SPADES, Rank.SEVEN),
                 new Card(Suit.SPADES, Rank.EIGHT));

        skeleton(11, 21, true, false, 5, 10, Hand.State.STAND,
                 new Card(Suit.CLUBS, Rank.SIX),
                 new Card(Suit.CLUBS, Rank.SEVEN),
                 new Card(Suit.CLUBS, Rank.EIGHT));

        skeleton(11, 21, true, false, 5, (float)7.5, Hand.State.STAND,
                 new Card(Suit.CLUBS, Rank.SIX),
                 new Card(Suit.CLUBS, Rank.SEVEN),
                 new Card(Suit.HEARTS, Rank.EIGHT));

        skeleton(11, 21, true, false, 5, (float)7.5, Hand.State.STAND,
                 new Card(Suit.CLUBS, Rank.FOUR),
                 new Card(Suit.CLUBS, Rank.FOUR),
                 new Card(Suit.CLUBS, Rank.FOUR),
                 new Card(Suit.CLUBS, Rank.FOUR),
                 new Card(Suit.CLUBS, Rank.FIVE));

        skeleton(11, 21, true, false, 5, 15, Hand.State.STAND,
                 new Card(Suit.CLUBS, Rank.THREE),
                 new Card(Suit.CLUBS, Rank.THREE),
                 new Card(Suit.CLUBS, Rank.THREE),
                 new Card(Suit.CLUBS, Rank.THREE),
                 new Card(Suit.CLUBS, Rank.THREE),
                 new Card(Suit.CLUBS, Rank.THREE),
                 new Card(Suit.CLUBS, Rank.THREE));

        skeleton(11, 21, true, false, 5, 10, Hand.State.STAND,
                 new Card(Suit.CLUBS, Rank.THREE),
                 new Card(Suit.CLUBS, Rank.THREE),
                 new Card(Suit.CLUBS, Rank.THREE),
                 new Card(Suit.CLUBS, Rank.THREE),
                 new Card(Suit.CLUBS, Rank.THREE),
                 new Card(Suit.CLUBS, Rank.SIX));

        skeleton(11, 21, true, false, 5, 5, Hand.State.STAND,
                 new Card(Suit.CLUBS, Rank.JACK),
                 new Card(Suit.CLUBS, Rank.FIVE),
                 new Card(Suit.CLUBS, Rank.SIX));

        skeleton(11, 18, true, false, 5, 0, Hand.State.STAND,
                 new Card(Suit.CLUBS, Rank.JACK),
                 new Card(Suit.CLUBS, Rank.EIGHT));

        skeleton(11, 19, true, false, 5, -5, Hand.State.STAND,
                 new Card(Suit.CLUBS, Rank.JACK),
                 new Card(Suit.CLUBS, Rank.EIGHT));
    }
}
