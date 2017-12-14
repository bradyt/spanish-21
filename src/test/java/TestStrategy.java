import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestStrategy {

    @Test
    public void testPickTable1() {
        Strategy strategy = new Strategy(Rules.H17);
        Hand hand = new Hand(0);
        hand.addCard("clubs", "two");
        hand.addCard("clubs", "two");
        assert(strategy.pickTable(hand) ==
               Strategy.StrategyTable.H17PAIR);
    }

    @Test
    public void testPickTable2() {
        Strategy strategy = new Strategy(Rules.H17);
        Hand hand = new Hand(0);
        hand.addCard("clubs", "ace");
        hand.addCard("clubs", "two");
        assert(strategy.pickTable(hand) ==
               Strategy.StrategyTable.H17SOFT);
    }

    @Test
    public void testPickTable3() {
        Strategy strategy = new Strategy(Rules.H17);
        Hand hand = new Hand(0);
        hand.addCard("clubs", "two");
        hand.addCard("clubs", "three");
        assert(strategy.pickTable(hand) ==
               Strategy.StrategyTable.H17HARD);
    }

    @Test
    public void testPickTable4() {
        Strategy strategy = new Strategy(Rules.S17);
        Hand hand = new Hand(0);
        hand.addCard("clubs", "two");
        hand.addCard("clubs", "two");
        assert(strategy.pickTable(hand) ==
               Strategy.StrategyTable.S17PAIR);
    }

    @Test
    public void testPickTable5() {
        Strategy strategy = new Strategy(Rules.S17);
        Hand hand = new Hand(0);
        hand.addCard("clubs", "ace");
        hand.addCard("clubs", "two");
        assert(strategy.pickTable(hand) ==
               Strategy.StrategyTable.S17SOFT);
    }

    @Test
    public void testPickTable6() {
        Strategy strategy = new Strategy(Rules.S17);
        Hand hand = new Hand(0);
        hand.addCard("clubs", "two");
        hand.addCard("clubs", "three");
        assert(strategy.pickTable(hand) ==
               Strategy.StrategyTable.S17HARD);
    }

    @Test
    public void testPickTable7() {
        Strategy strategy = new Strategy(Rules.H17REDOUBLE);
        Hand hand = new Hand(0);
        hand.addCard("clubs", "two");
        hand.addCard("clubs", "two");
        assert(strategy.pickTable(hand) ==
               Strategy.StrategyTable.H17DOUBLEDNOTYET);
    }

    @Test
    public void testPickTable8() {
        Strategy strategy = new Strategy(Rules.H17REDOUBLE);
        Hand hand = new Hand(0);
        hand.addCard("clubs", "ace");
        hand.addCard("clubs", "two");
        hand.incrementNumOfDoublings();
        assert(strategy.pickTable(hand) ==
               Strategy.StrategyTable.H17DOUBLEDSOFT);
    }

    @Test
    public void testPickTable9() {
        Strategy strategy = new Strategy(Rules.H17REDOUBLE);
        Hand hand = new Hand(0);
        hand.addCard("clubs", "two");
        hand.addCard("clubs", "three");
        hand.incrementNumOfDoublings();
        assert(strategy.pickTable(hand) ==
               Strategy.StrategyTable.H17DOUBLEDHARD);
    }

    public void skeleton(Rules rules, int upCardPoint, String lookupValue,
                         Card... cards) {
        Strategy strategy = new Strategy(rules);
        Hand hand = new Hand(0);
        for (Card card : cards) {
            hand.addCard(card);
        }
        String cell = strategy.getCell(hand, upCardPoint);
        assertEquals(cell, lookupValue);
    }

    @Test
    public void testStrategy1() {
        Strategy strategy = new Strategy(Rules.H17);
        Hand hand = new Hand(0);
        hand.addCard("clubs", "two");
        hand.addCard("clubs", "two");
        assert(strategy.getCell(hand, 2).equals("p"));
    }

    @Test
    public void testStrategy2() {
        Strategy strategy = new Strategy(Rules.H17);
        Hand hand = new Hand(0);
        hand.addCard("clubs", "nine");
        hand.addCard("clubs", "nine");
        assert(strategy.getCell(hand, 5).equals("p"));
    }

    @Test
    public void testStrategy3() {
        Strategy strategy = new Strategy(Rules.H17);
        Hand hand = new Hand(0);
        hand.addCard("clubs", "four");
        hand.addCard("clubs", "four");
        assert(strategy.getCell(hand, 5).equals("h"));
    }

    @Test
    public void testStrategy4() {
        Strategy strategy = new Strategy(Rules.H17);
        Hand hand = new Hand(0);
        hand.addCard("clubs", "seven");
        hand.addCard("clubs", "seven");
        assert(strategy.getCell(hand, 7).equals("p$"));
    }

    @Test
    public void testStrategy5() {
        Strategy strategy = new Strategy(Rules.H17);
        Hand hand = new Hand(0);
        hand.addCard("clubs", "seven");
        hand.addCard("clubs", "seven");
        assert(strategy.isSuited(hand));
    }

    @Test
    public void testStrategy6() {
        Strategy strategy = new Strategy(Rules.H17);
        Hand hand = new Hand(0);
        hand.addCard("clubs", "seven");
        hand.addCard("clubs", "seven");
        Hand dealer = new Hand();
        dealer.addCard("clubs", "seven");
        dealer.addCard("clubs", "seven");
        assert(strategy.getAction(hand, dealer, true) == Action.HIT);
    }

    @Test
    public void testStrategy7() {
        Strategy strategy = new Strategy(Rules.H17);
        Hand hand = new Hand(0);
        hand.addCard("clubs", "six");
        hand.addCard("clubs", "seven");
        assert(strategy.possible678(hand));
    }

    @Test
    public void testStrategy8() {
        Strategy strategy = new Strategy(Rules.H17);
        Hand hand = new Hand(0);
        hand.addCard("clubs", "six");
        hand.addCard("clubs", "seven");
        Hand dealer = new Hand();
        dealer.addCard("clubs", "six");
        dealer.addCard("clubs", "six");
        assert(strategy.getAction(hand, dealer, true) == Action.SPLIT);
    }

    @Test
    public void testStrategy9() {
        Strategy strategy = new Strategy(Rules.H17);
        Hand hand = new Hand(0);
        hand.addCard("hearts", "nine");
        hand.addCard("hearts", "ace");
        Hand dealer = new Hand();
        dealer.addCard("clubs", "six");
        dealer.addCard("clubs", "six");
        assert(strategy.getAction(hand, dealer, true) == Action.STAND);
    }
}
