import org.junit.Test;
import static org.junit.Assert.*;

public class TestHand {

    @Test
    public void testState() {
        Shoe shoe = new Shoe(0);
        Hand hand = new Hand();
        Hands hands = new Hands();
        hand.applyAction(Action.STAND, shoe, hands);
        assertEquals(hand.getState(), Hand.State.STAND);
    }

    @Test
    public void testTotal() {
        Hand hand = new Hand();
        hand.addCard("clubs", "three");
        hand.addCard("clubs", "four");
        assert(hand.getPointTotal() == 7);
    }

    @Test
    public void testTotal21() {
        Hand hand = new Hand();
        hand.addCard("clubs", "ace");
        hand.addCard("clubs", "jack");
        assert(hand.getPointTotal() == 21);
    }

    public void testIsBlackjack1() {
        Hand hand = new Hand();
        hand.addCard("clubs", "ace");
        hand.addCard("clubs", "jack");
        assert(hand.isBlackjack());
    }

    @Test
    public void testIsBlackjack2() {
        Hand hand = new Hand();
        hand.addCard("clubs", "ace");
        hand.addCard("clubs", "nine");
        assert(!hand.isBlackjack());
    }

    @Test
    public void testIsBlackjack3() {
        Hand hand = new Hand();
        hand.addCard("clubs", "ace");
        hand.addCard("clubs", "jack");
        hand.addCard("clubs", "jack");
        assert(!hand.isBlackjack());
    }

}
