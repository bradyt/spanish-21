import java.util.*;
import java.io.*;
import org.apache.commons.csv.*;

class Strategy {
    private Rules rules;
    private Tables tables;

    Strategy(Rules rules) {
        this.rules = rules;
        tables = new Tables();
    }

    Action getAction(int upcard, Hand hand, boolean canSplit) {

        // String action = getStrategyString(upcard, hand, canSplit);
        String action = tables.getCell(rules, upcard, hand);

        char actionChar = action.toUpperCase().charAt(0);
        int digit = getDigit(action);
        char specialChar = getSpecialChar(action);

        if (hand.getCards().size() >= digit) {return Action.HIT;}
        if (possible678AgainstSpecialChar(hand, specialChar)) {
            return Action.HIT;
        }
        if (action.equals("p$") && hand.isSuited()) {return Action.HIT;}

        switch (actionChar) {
        case 'H': return Action.HIT;
        case 'S': return Action.STAND;
        case 'P': return Action.SPLIT;
        case 'D': return Action.DOUBLE;
        case 'R': return Action.SURRENDER;
        }
        return Action.HIT;
    }

    boolean possible678(Hand hand) {
        int pt0 = hand.getCards().get(0).getPoint();
        int pt1 = hand.getCards().get(1).getPoint();
        if (pt0 == 6 && pt1 == 7 || pt1 == 8) {
            return true;
        }
        if (pt0 == 7 && pt1 == 6 || pt1 == 8) {
            return true;
        }
        if (pt0 == 8 && pt1 == 6 || pt1 == 7) {
            return true;
        }
        return false;
    }
 
    boolean possible678AgainstSpecialChar(Hand hand, char specialChar) {
        List<Integer> sixSevenEight = Arrays.asList(6, 7, 8);
        boolean bool = possible678(hand);
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
                if (isSpaded(hand)) {
                    return true;
                }
            }
        }
        return false;
    }
 
    boolean isSpaded(Hand hand) {
        for (Card card : hand.getCards()) {
            if (card.getSuit() != Suit.SPADES) {
                return false;
            }
        }
        return true;
    }

    boolean isSuited(Hand hand) {
        Suit suit = hand.getCards().get(0).getSuit();
        for (Card card : hand.getCards()) {
            if (card.getSuit() != suit) {
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
        return 0;
    }

}
