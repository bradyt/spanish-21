class Payout {
    static float calculatePayout(int upcardPoint,
                                 int dealersPointTotal,
                                 Hand hand,
                                 boolean hasSplit) {
        int playersPointTotal = hand.getPointTotal();
        float bet = hand.getBet();
        int numOfCards;
        boolean has777;
        boolean isSuited;
        boolean isSpaded;
        switch (hand.getState()) {
        case BUSTED: case LOSTTODEALERBLACKJACK:
            return -bet;
        case BLACKJACK:
            return (float)1.5 * bet;
        case SURRENDERED:
            return -(float)0.5 * bet;
        case STAND:
            if (playersPointTotal == 21) {
                if (!hand.hasDoubled()) {
                    has777 = hand.has777();
                    isSuited = hand.isSuited();
                    isSpaded = hand.isSpaded();
                    if (has777 || hand.has678()) {
                        if (has777) {
                            if (upcardPoint == 7 && !hasSplit && isSuited) {
                                if (bet >= 25) {
                                    return 5000;
                                } else {
                                    return 1000;
                                }
                            }
                        } else if (isSpaded) {
                            return 3 * bet;
                        } else if (isSuited) {
                            return 2 * bet;
                        } else {
                            return (float)1.5 * bet;
                        }
                    }
                    numOfCards = hand.getNumOfCards();
                    if (numOfCards >= 7) {
                        return 3 * bet;
                    }  else if (numOfCards == 6) {
                        return 2 * bet;
                    }  else if (numOfCards == 5) {
                        return (float)1.5 * bet;
                    }
                } else {
                    return bet;
                }
            } else if (playersPointTotal > dealersPointTotal) {
                return bet;
            } else if (playersPointTotal == dealersPointTotal) {
                return 0;
            }
        }
        return -bet;
    }
}
