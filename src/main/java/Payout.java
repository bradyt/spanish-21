import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

class Payout {
    static float calculatePayout(Bet bet, int dealersPointTotal, int dealersUpcard, boolean hasSplit) {
        int playersPointTotal = bet.getPointTotal();
        float betAmount = bet.getBetAmount();
        int numOfCards = bet.getNumOfCards();
        boolean hasDoubled = bet.hasDoubled();
        boolean has678 = bet.has678();
        boolean has777 = bet.has777();
        boolean isSuited = bet.isSuited();
        boolean isSpaded = bet.isSpaded();
        if (!hasDoubled && !hasSplit && has777 && isSuited) {
            if (betAmount >= 25) {
                return 5000;
            } else {
                return 1000;
            }
        } else if (!hasDoubled && playersPointTotal == 21) {
            if (numOfCards >= 7) {
                return 3 * betAmount;
            }  else if (numOfCards == 6) {
                return 2 * betAmount;
            }  else if (numOfCards == 5) {
                return (float)1.5 * betAmount;
            } else if (has678 || has777) {
                if (isSpaded) {
                    return 3 * betAmount;
                } else if (isSuited) {
                    return 2 * betAmount;
                } else {
                    return (float)1.5 * betAmount;
                }
            }
        } else if (hasDoubled && playersPointTotal >= dealersPointTotal) {
            // TODO: you totally skipped the case where they have not doubled,
            // but still have some vanilla 21, write a test and fix it.
            return betAmount;
        }
        return 0;
    }
}
