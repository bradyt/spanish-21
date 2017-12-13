import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestBet {
    @Test
    public void testBet1() {
        Bet bet = new Bet(0);
        bet.incrementNumOfDoublings();
        assert(bet.hasDoubled());
    }

    @Test
    public void testBet2() {
        Bet bet = new Bet(0);
        assert(!bet.hasDoubled());
    }

    @Test
    public void testBet3() {
        Bet bet = new Bet(0);
        bet.addCard("clubs", "seven");
        bet.addCard("clubs", "seven");
        bet.addCard("clubs", "seven");
        assert(bet.has777());
        assert(bet.isSuited());
    }
}
