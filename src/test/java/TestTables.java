import java.util.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestTables {

    public void skeleton(Rules rules,
                         Hand hand,
                         int upcard,
                         String cell) {
        Tables tables = new Tables();
        assertEquals(tables.getCell(rules, upcard, hand),
                     cell);
    }

    @Test
    public void testGetCell1() {
        Hand hand = new Hand(0);
        hand.addCard("clubs", "two");
        hand.addCard("clubs", "two");
        skeleton(Rules.S17, hand, 2, "p");
    }


    // @Test
    // public void testPickTable1() {
    //     Tables tables = new Tables(Rules.H17);
    //     Hand hand = new Hand(0);
    //     hand.addCard("clubs", "two");
    //     hand.addCard("clubs", "two");
    //     assert(tables.pickTable(hand) ==
    //            Tables.TablesTable.H17PAIR);
    // }

    // @Test
    // public void testPickTable2() {
    //     Tables tables = new Tables(Rules.H17);
    //     Hand hand = new Hand(0);
    //     hand.addCard("clubs", "ace");
    //     hand.addCard("clubs", "two");
    //     assert(tables.pickTable(hand) ==
    //            Tables.TablesTable.H17SOFT);
    // }

    // @Test
    // public void testPickTable3() {
    //     Tables tables = new Tables(Rules.H17);
    //     Hand hand = new Hand(0);
    //     hand.addCard("clubs", "two");
    //     hand.addCard("clubs", "three");
    //     assert(tables.pickTable(hand) ==
    //            Tables.TablesTable.H17HARD);
    // }

    // @Test
    // public void testPickTable4() {
    //     Tables tables = new Tables(Rules.S17);
    //     Hand hand = new Hand(0);
    //     hand.addCard("clubs", "two");
    //     hand.addCard("clubs", "two");
    //     assert(tables.pickTable(hand) ==
    //            Tables.TablesTable.S17PAIR);
    // }

    // @Test
    // public void testPickTable5() {
    //     Tables tables = new Tables(Rules.S17);
    //     Hand hand = new Hand(0);
    //     hand.addCard("clubs", "ace");
    //     hand.addCard("clubs", "two");
    //     assert(tables.pickTable(hand) ==
    //            Tables.TablesTable.S17SOFT);
    // }

    // @Test
    // public void testPickTable6() {
    //     Tables tables = new Tables(Rules.S17);
    //     Hand hand = new Hand(0);
    //     hand.addCard("clubs", "two");
    //     hand.addCard("clubs", "three");
    //     assert(tables.pickTable(hand) ==
    //            Tables.TablesTable.S17HARD);
    // }

    // @Test
    // public void testPickTable7() {
    //     Tables tables = new Tables(Rules.H17REDOUBLE);
    //     Hand hand = new Hand(0);
    //     hand.addCard("clubs", "two");
    //     hand.addCard("clubs", "two");
    //     assert(tables.pickTable(hand) ==
    //            Tables.TablesTable.H17DOUBLEDNOTYET);
    // }

    // @Test
    // public void testPickTable8() {
    //     Tables tables = new Tables(Rules.H17REDOUBLE);
    //     Hand hand = new Hand(0);
    //     hand.addCard("clubs", "ace");
    //     hand.addCard("clubs", "two");
    //     hand.incrementNumOfDoublings();
    //     assert(tables.pickTable(hand) ==
    //            Tables.TablesTable.H17DOUBLEDSOFT);
    // }

    // @Test
    // public void testPickTable9() {
    //     Tables tables = new Tables(Rules.H17REDOUBLE);
    //     Hand hand = new Hand(0);
    //     hand.addCard("clubs", "two");
    //     hand.addCard("clubs", "three");
    //     hand.incrementNumOfDoublings();
    //     assert(tables.pickTable(hand) ==
    //            Tables.TablesTable.H17DOUBLEDHARD);
    // }

    public void skeleton(Rules rules, int upcard, String lookupValue,
                         Card... cards) {
        Tables tables = new Tables();
        Hand hand = new Hand(0);
        for (Card card : cards) {
            hand.addCard(card);
        }
        String cell = tables.getCell(rules, upcard, hand);
        assertEquals(cell, lookupValue);
    }

    // @Test
    // public void testTables1() {
    //     Tables tables = new Tables(Rules.H17);
    //     Hand hand = new Hand(0);
    //     hand.addCard("clubs", "two");
    //     hand.addCard("clubs", "two");
    //     assert(tables.getCell(hand, 2).equals("p"));
    // }

    // @Test
    // public void testTables2() {
    //     Tables tables = new Tables(Rules.H17);
    //     Hand hand = new Hand(0);
    //     hand.addCard("clubs", "nine");
    //     hand.addCard("clubs", "nine");
    //     assert(tables.getCell(hand, 5).equals("p"));
    // }

    // @Test
    // public void testTables3() {
    //     Tables tables = new Tables(Rules.H17);
    //     Hand hand = new Hand(0);
    //     hand.addCard("clubs", "four");
    //     hand.addCard("clubs", "four");
    //     assert(tables.getCell(hand, 5).equals("h"));
    // }

    // @Test
    // public void testTables4() {
    //     Rules rules = Rules.H17;
    //     Tables tables = new Tables();
    //     Hand hand = new Hand(0);
    //     hand.addCard("clubs", "seven");
    //     hand.addCard("clubs", "seven");
    //     assert(tables.getCell(rules, hand, 7).equals("p$"));
    // }

    // @Test
    // public void testTables5() {
    //     Tables tables = new Tables(Rules.H17);
    //     Hand hand = new Hand(0);
    //     hand.addCard("clubs", "seven");
    //     hand.addCard("clubs", "seven");
    //     assert(tables.isSuited(hand));
    // }

    // @Test
    // public void testTables6() {
    //     Tables tables = new Tables(Rules.H17);
    //     Hand hand = new Hand(0);
    //     hand.addCard("clubs", "seven");
    //     hand.addCard("clubs", "seven");
    //     assert(tables.getAction(7, hand, true) == Action.HIT);
    // }

    // @Test
    // public void testTables7() {
    //     Tables tables = new Tables(Rules.H17);
    //     Hand hand = new Hand(0);
    //     hand.addCard("clubs", "six");
    //     hand.addCard("clubs", "seven");
    //     assert(tables.possible678(hand));
    // }

    // @Test
    // public void testTables8() {
    //     Tables tables = new Tables(Rules.H17);
    //     Hand hand = new Hand(0);
    //     hand.addCard("clubs", "six");
    //     hand.addCard("clubs", "seven");
    //     assert(tables.getAction(6, hand, true) == Action.HIT);
    // }

    // @Test
    // public void testTables9() {
    //     Tables tables = new Tables(Rules.H17);
    //     Hand hand = new Hand(0);
    //     hand.addCard("hearts", "nine");
    //     hand.addCard("hearts", "ace");
    //     assert(tables.getAction(6, hand, true) == Action.STAND);
    // }
}
