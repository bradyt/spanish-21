import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJunit {

    @Test
    public void testCard() {
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(suit, rank);
                assertEquals(card.getSuit(), suit);
                assertEquals(card.getRank(), rank);
            }
        }

        Card card;

        card = new Card(Suit.CLUBS, Rank.ACE);
        assertEquals(card.getPoint(), 11);
        
        card = new Card(Suit.CLUBS, Rank.KING);
        assertEquals(card.getPoint(), 10);

        card = new Card(Suit.CLUBS, Rank.FOUR);
        assertEquals(card.getPoint(), 4);
    }

}
