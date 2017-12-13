import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestAction {

    @Test
    public void testAction() {
        // Shoe shoe;

        // shoe = new Shoe(0);
        // shoe.addCardByString("clubs", "ace");
        // shoe.addCardByString("clubs", "ace");
        // shoe.addCardByString("clubs", "jack");
        // shoe.addCardByString("clubs", "nine");

        // Bet bet = new Bet(0);
        // bet.addCardByString("clubs", "six");
        // bet.addCardByString("clubs", "seven");
        // assert(strategy.getAction(bet, 6, 0) == Action.HIT);

        /* let's test
           make sure dealer does right thing for various actions

           hit deals a card
           stand puts hand on stoodHands
           double deals a card, increments counter and doubles bet
           split duplicates, deals a card to each, and increments counter
           surrender removes hand and takes half of bet
        */

        // for (Rules rules : Rules.values()) {
        //     Dealer dealer = new Dealer(rules, 5);
        //     dealer.addPlayer(15);
        //     assertEquals(dealer.getPlayer().getMoney(), 15);
        // }
    }

}
