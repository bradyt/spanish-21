class Strategy {
    Rules rules;
    Card upCard;
    Hand hand;
    boolean hasDoubled;

    Strategy(Rules rules) {
        this.rules = rules;
    }

    void setUpcard(Card card) {
        upCard = card;
    }

    Action chooseAction() {
        String action =
            actionMatrixLookup(rules, hasDoubled, value, hasAce, twins);
        char actionChar = action.getCharAt(0);
        int digit = getDigits(action);
        char specialChar = getSpecialChar(action);

        if (hand.size() >= digit) {return Action.HIT;}

        if (string.equals("P$") && suitedSevens(hand)) {return Action.HIT;}

        if (possible678(hand, specialChar)) {return Action.HIT;}

        switch (actionChar) {
        case 'H': return Action.HIT;
        case 'S': return Action.STAND;
        case 'P': return Action.SPLIT;
        case 'D': return Action.DOUBLE;
        case 'R': return Action.SURRENDER;
        }
    }

    boolean suitedSevens(Hand hand) {
        for (Card card : hand.getCards()) {
            if (card.rank != Rank.SEVEN) {
                return false;
            }
        }
        return true;
    }

    boolean possible678(Hand hand, char specialChar) {
        ArrayList sixSevenEight = ArrayList.toList(6, 7, 8);
        boolean bool = sixSevenEight.containsAll(hand);
        if (bool == true) {
            if (specialChar == '*') {
                return true;
            } else if (specialChar == '\'') {
                if (isSuited(hand) || isSpaded(hand)) {
                    return true;
                } else {
                    return false;
                }
            } else if (specialChar == '"') {
                if (spaded(hand)) {
                    return true;
                }
            }
        }
        return false;
    }

    boolean isSpaded() {
        for (Card card : hand) {
            if (card.suit != Suit.SPADES) {
                return false;
            }
        }
        return true;
    }

    boolean isSuited() {
        Suit suit = hand.get(0);
        for (Card card : hand) {
            if (card.suit != suit) {
                return false;
            }
        }
        return true;
    }

    int getDigit(String string) {
        if (string.contains("4")) {
            return 4;
        } else if (string.contains("5")) {
            return 5;
        } else if (string.contains("6")) {
            return 6;
        }
        return Integer.MAX_VALUE;
    }
            
    char getSpecialChar(String string) {
        if (string.contains("*")) {
            return '*';
        } else if (string.contains("'")) {
            return '\'';
        } else if (string.contains("\"")) {
            return '"';
    }

}
