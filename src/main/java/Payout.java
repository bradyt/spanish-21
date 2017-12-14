import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

class Payout {
    static float calculatePayout(Hand dealer, Hand hand, boolean hasSplit) {
        int dealersPointTotal = dealer.getPointTotal();
        int dealersUpcard = dealer.getUpcardPoint();
        int playersPointTotal = hand.getPointTotal();
        float bet = hand.getBet();
        int numOfCards = hand.getNumOfCards();
        boolean hasDoubled = hand.hasDoubled();
        boolean has678 = hand.has678();
        boolean has777 = hand.has777();
        boolean isSuited = hand.isSuited();
        boolean isSpaded = hand.isSpaded();
        Hand.State state = hand.getState();
        switch (state) {
        case BUSTED: case LOSTTODEALERBLACKJACK:
            return -bet;
        case BLACKJACK:
            return (float)1.5 * bet;
        case SURRENDERED:
            return -(float)0.5 * bet;
        case STAND:
            if (playersPointTotal < dealersPointTotal) {
                return -bet;
            } else if (!hasDoubled && !hasSplit && has777 && isSuited) {
                if (bet >= 25) {
                    return 5000;
                } else {
                    return 1000;
                }
            } else if (!hasDoubled && playersPointTotal == 21) {
                if (numOfCards >= 7) {
                    return 3 * bet;
                }  else if (numOfCards == 6) {
                    return 2 * bet;
                }  else if (numOfCards == 5) {
                    return (float)1.5 * bet;
                } else if (has678 || has777) {
                    if (isSpaded) {
                        return 3 * bet;
                    } else if (isSuited) {
                        return 2 * bet;
                    } else {
                        return (float)1.5 * bet;
                    }
                }
            } else if (playersPointTotal > dealersPointTotal) {
                return bet;
            } else if (playersPointTotal == dealersPointTotal) {
                return 0;
            }
        }
        return 0;
    }
}
