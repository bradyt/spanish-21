import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestStrategy {

    @Test
    public void testPickTable1() {
        Strategy strategy = new Strategy(Rules.H17);
        Bet bet = new Bet(0);
        bet.addCardByString("clubs", "two");
        bet.addCardByString("clubs", "two");
        assert(strategy.pickTable(bet) ==
               Strategy.StrategyTable.H17PAIR);
    }

    @Test
    public void testPickTable2() {
        Strategy strategy = new Strategy(Rules.H17);
        Bet bet = new Bet(0);
        bet.addCardByString("clubs", "ace");
        bet.addCardByString("clubs", "two");
        assert(strategy.pickTable(bet) ==
               Strategy.StrategyTable.H17SOFT);
    }

    @Test
    public void testPickTable3() {
        Strategy strategy = new Strategy(Rules.H17);
        Bet bet = new Bet(0);
        bet.addCardByString("clubs", "two");
        bet.addCardByString("clubs", "three");
        assert(strategy.pickTable(bet) ==
               Strategy.StrategyTable.H17HARD);
    }

    @Test
    public void testPickTable4() {
        Strategy strategy = new Strategy(Rules.S17);
        Bet bet = new Bet(0);
        bet.addCardByString("clubs", "two");
        bet.addCardByString("clubs", "two");
        assert(strategy.pickTable(bet) ==
               Strategy.StrategyTable.S17PAIR);
    }

    @Test
    public void testPickTable5() {
        Strategy strategy = new Strategy(Rules.S17);
        Bet bet = new Bet(0);
        bet.addCardByString("clubs", "ace");
        bet.addCardByString("clubs", "two");
        assert(strategy.pickTable(bet) ==
               Strategy.StrategyTable.S17SOFT);
    }

    @Test
    public void testPickTable6() {
        Strategy strategy = new Strategy(Rules.S17);
        Bet bet = new Bet(0);
        bet.addCardByString("clubs", "two");
        bet.addCardByString("clubs", "three");
        assert(strategy.pickTable(bet) ==
               Strategy.StrategyTable.S17HARD);
    }

    @Test
    public void testPickTable7() {
        Strategy strategy = new Strategy(Rules.H17REDOUBLE);
        Bet bet = new Bet(0);
        bet.addCardByString("clubs", "two");
        bet.addCardByString("clubs", "two");
        assert(strategy.pickTable(bet) ==
               Strategy.StrategyTable.H17DOUBLEDNOTYET);
    }

    @Test
    public void testPickTable8() {
        Strategy strategy = new Strategy(Rules.H17REDOUBLE);
        Bet bet = new Bet(0);
        bet.addCardByString("clubs", "ace");
        bet.addCardByString("clubs", "two");
        bet.incrementNumOfDoublings();
        assert(strategy.pickTable(bet) ==
               Strategy.StrategyTable.H17DOUBLEDSOFT);
    }

    @Test
    public void testPickTable9() {
        Strategy strategy = new Strategy(Rules.H17REDOUBLE);
        Bet bet = new Bet(0);
        bet.addCardByString("clubs", "two");
        bet.addCardByString("clubs", "three");
        bet.incrementNumOfDoublings();
        assert(strategy.pickTable(bet) ==
               Strategy.StrategyTable.H17DOUBLEDHARD);
    }

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

    @Test
    public void testStrategy1() {
        Strategy strategy = new Strategy(Rules.H17);
        Bet bet = new Bet(0);
        bet.addCardByString("clubs", "two");
        bet.addCardByString("clubs", "two");
        assert(strategy.getCell(bet, 2).equals("p"));
    }

    @Test
    public void testStrategy2() {
        Strategy strategy = new Strategy(Rules.H17);
        Bet bet = new Bet(0);
        bet.addCardByString("clubs", "nine");
        bet.addCardByString("clubs", "nine");
        assert(strategy.getCell(bet, 5).equals("p"));
    }

    @Test
    public void testStrategy3() {
        Strategy strategy = new Strategy(Rules.H17);
        Bet bet = new Bet(0);
        bet.addCardByString("clubs", "four");
        bet.addCardByString("clubs", "four");
        assert(strategy.getCell(bet, 5).equals("h"));
    }

    @Test
    public void testStrategy4() {
        Strategy strategy = new Strategy(Rules.H17);
        Bet bet = new Bet(0);
        bet.addCardByString("clubs", "seven");
        bet.addCardByString("clubs", "seven");
        assert(strategy.getCell(bet, 7).equals("p$"));
    }

    @Test
    public void testStrategy5() {
        Strategy strategy = new Strategy(Rules.H17);
        Bet bet = new Bet(0);
        bet.addCardByString("clubs", "seven");
        bet.addCardByString("clubs", "seven");
        assert(strategy.isSuited(bet));
    }

    @Test
    public void testStrategy6() {
        Strategy strategy = new Strategy(Rules.H17);
        Bet bet = new Bet(0);
        bet.addCardByString("clubs", "seven");
        bet.addCardByString("clubs", "seven");
        assert(strategy.getAction(bet, 7, 0) == Action.HIT);
    }

    @Test
    public void testStrategy7() {
        Strategy strategy = new Strategy(Rules.H17);
        Bet bet = new Bet(0);
        bet.addCardByString("clubs", "six");
        bet.addCardByString("clubs", "seven");
        assert(strategy.possible678(bet));
    }

    @Test
    public void testStrategy8() {
        Strategy strategy = new Strategy(Rules.H17);
        Bet bet = new Bet(0);
        bet.addCardByString("clubs", "six");
        bet.addCardByString("clubs", "seven");
        assert(strategy.getAction(bet, 6, 0) == Action.HIT);
    }
}
