import java.util.Arrays;
import java.util.ArrayList;

class Hand {

    private ArrayList<Card> hand;
    private boolean soft;

    Hand () {
        hand = new ArrayList<Card>();
    }

    void addCard(Card card) {
        hand.add(card);
    }

    int getPointTotal() {
        int aces = 0;
        int ptTot = 0;
        for (Card card : hand) {
            if (card.equals(Rank.ACE)) {
                aces++;
            }
            ptTot = ptTot + card.getPoint();
        }
        while (ptTot > 21 && aces > 0) {
            ptTot -= 10;
            aces--;
        }
        return ptTot;
    }

    boolean isSoft() {
        return false;
    }

    boolean isSoft17() {
        return false;
    }

    String getLookupFormat() {
        String s0 = hand.get(0).getLookupFormat();
        String s1 = hand.get(1).getLookupFormat();
        if (s1.equals("A")) {
            return s1 + "," + s0;
        } else {
            return s0 + "," + s1;
        }
    }

    ArrayList<Card> getCards() {
        return hand;
    }

    boolean isBlackjack() {
        return (hand.size() == 2 && getPointTotal() == 21);
    }

    boolean isPair() {
        return (hand.size() == 2 && (hand.get(0).getRank() == hand.get(1).getRank()));
    }
            
    boolean containsOneOfFollowingPoints(int... points) {
        // boolean treatAsPair = (bet.isPair() && !List.asList(4, 5, 10).contains(bet.getAValue()));
        for (int point : points) {
            for (Card card : hand) {
                if (card.getPoint() == point) {
                    return true;
                }
            }
        }
        return false;
    }

    public String toString() {
        String result = "";
        for (Card card : getCards()) {
            result += card.toString();
        }
        return result;
    }
}
