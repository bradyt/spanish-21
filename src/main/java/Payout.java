class Payout {
    static float calculatePayout(int upcard,
                                 int dealersPointTotal,
                                 Hand hand,
                                 boolean hasSplit) {
        int playersPointTotal = hand.getPointTotal();
        float bet = hand.getBet();
        switch (hand.getState()) {
        case BUSTED: case LOSTTODEALERBLACKJACK:
            return -bet;
        case BLACKJACK:
            return (float)1.5 * bet;
        case SURRENDERED:
            return -(float)0.5 * bet;
        case STAND:
            if (playersPointTotal == 21) {
                return calculate21Payout(bet,
                                         upcard,
                                         dealersPointTotal,
                                         hand,
                                         hasSplit);
            } else if (playersPointTotal > dealersPointTotal) {
                return bet;
            } else if (playersPointTotal == dealersPointTotal) {
                return 0;
            }
        }
        return -bet;
    }
    static float calculate21Payout(float bet,
                                  int upcard,
                                  int dealersPointTotal,
                                  Hand hand,
                                  boolean hasSplit) {
        if (!hand.hasDoubled()) {
            boolean has777 = hand.has777();
            boolean isSuited = hand.isSuited();
            boolean isSpaded = hand.isSpaded();
            int numOfCards = hand.getNumOfCards();
            if (has777 || hand.has678()) {
                if (has777) {
                    if (upcard == 7 && !hasSplit && isSuited) {
                        if (bet >= 25) {
                            return 5000;
                        } else {
                            return 1000;
                        }
                    }
                }
                if (isSpaded) {
                    return 3 * bet;
                } else if (isSuited) {
                    return 2 * bet;
                } else {
                    return (float)1.5 * bet;
                }
            }
            if (numOfCards >= 7) {
                return 3 * bet;
            }  else if (numOfCards == 6) {
                return 2 * bet;
            }  else if (numOfCards == 5) {
                return (float)1.5 * bet;
            }
        } 
        return bet;
    }
}
