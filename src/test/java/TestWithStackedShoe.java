import static org.junit.Assert.assertEquals;

public class TestWithStackedShoe {
    public void testWithStackedShoe() {
        Shoe shoe;

        shoe = new Shoe(0);
        shoe.addCardByString("clubs", "ace");
        shoe.addCardByString("clubs", "ace");
        shoe.addCardByString("clubs", "jack");
        shoe.addCardByString("clubs", "nine");

        testCase(shoe, (float)107.5);

        shoe = new Shoe(0);
        shoe.addCardByString("clubs", "ace");
        shoe.addCardByString("clubs", "ace");
        shoe.addCardByString("clubs", "nine");
        shoe.addCardByString("clubs", "jack");

        testCase(shoe, (float)95.0);
    }

    public void testCase(Shoe shoe, float endAmount) {
        Dealer dealer = new Dealer(Rules.H17REDOUBLE, shoe);
        dealer.addPlayer(100);
        dealer.getPlayer().addBet(5);
        dealer.dealHands();
        dealer.assessBlackjacks();
        assertEquals(dealer.getPlayer().getMoney(), endAmount, 0);
    }
}
