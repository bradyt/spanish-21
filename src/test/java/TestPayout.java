import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestPayout {
    /*
      make sure dealer pays out correctly for various bets

      blackjack pays 3:2
      surrender gives back 1:2
      busted pays 0
      double down rescue gives back last bet

      - not paid after doubling
      5 card 21 pays 3:2
      6 card 21 pays 2:1
      7 card 21 pays 3:1

      - not paid after doubling
      678 or 777 of mixed suit pays 3:2
      678 or 777 of same suit pays 2:1
      678 or 777 of spades pays 3:1

      - not paid after doubling or splitting
      suited 777 w/ 7 upcard pays
      - 1000 for 5..24
      - 5000 for 25..

    */
    // assert(false);

    @Test
    public void testPayout1() {
        Bet bet = new Bet(25);
        bet.addCard("clubs", "six");
        bet.addCard("clubs", "seven");
        float payout = Payout.calculatePayout(bet, 17, 7, false);
        assert(payout == 0);
    }

    @Test
    public void testPayout2() {
        Bet bet = new Bet(25);
        bet.addCard("clubs", "six");
        bet.addCard("clubs", "seven");
        bet.incrementNumOfDoublings();
        float payout = Payout.calculatePayout(bet, 10, 7, true);
        assert(payout == 25);
    }

    @Test
    public void testPayout3() {
        Bet bet = new Bet(10);
        bet.addCard("clubs", "four");
        bet.addCard("clubs", "four");
        bet.addCard("clubs", "four");
        bet.addCard("clubs", "four");
        bet.addCard("hearts", "five");
        float payout = Payout.calculatePayout(bet, 21, 7, true);
        assert(payout == 15);
    }

    @Test
    public void testPayout4() {
        Bet bet = new Bet(5);
        bet.addCard("clubs", "seven");
        bet.addCard("clubs", "seven");
        bet.addCard("clubs", "seven");
        float payout = Payout.calculatePayout(bet, 17, 7, false);
        assert(payout == 1000);
    }

    @Test
    public void testPayout5() {
        Bet bet = new Bet(25);
        bet.addCard("clubs", "seven");
        bet.addCard("clubs", "seven");
        bet.addCard("clubs", "seven");
        float payout = Payout.calculatePayout(bet, 17, 7, false);
        assert(payout == 5000);
    }

}
