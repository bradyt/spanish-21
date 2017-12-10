import java.util.*;
import static org.junit.Assert.*;

public class TestStrategy {
    public void skeleton(Rules rules, int upCardPoint, String lookupValue,
                         Card... cards) {
        Strategy strategy = new Strategy(rules);
        Bet bet = new Bet(0);
        for (Card card : cards) {
            bet.addCard(card);
        }
        String cell = strategy.getCell(bet, upCardPoint);
        assertEquals(cell, lookupValue);
    }

    public Card makeCard(String suit, String rank) {
        Suit s = Suit.valueOf(suit.toUpperCase());
        Rank r = Rank.valueOf(rank.toUpperCase());
        return new Card(s, r);
    }

    public void testStrategy() {
        skeleton(Rules.H17REDOUBLE, 5, "p",
                 makeCard("clubs", "nine"),
                 makeCard("clubs", "nine"));

        skeleton(Rules.H17REDOUBLE, 5, "d",
                 makeCard("clubs", "four"),
                 makeCard("clubs", "four"));
    }
}
