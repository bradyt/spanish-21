import java.util.List;
import java.util.ArrayList;

class Hands {

    private ArrayList<Hand> hands;
    private int numOfSplits;

    Hands() {
        hands = new ArrayList<Hand>();
        numOfSplits = 0;
    }

    boolean hasSplit() {
        return numOfSplits > 0;
    }

    boolean canSplit() {
        return numOfSplits < 3;
    }

    void addFirstHand(Hand hand) {
        hands.add(hand);
    }

    void addSplitHand(Hand hand) {
        hands.add(hand);
        numOfSplits++;
    }

    List<Hand> getHands() {
        return hands;
    }

    boolean hasActionableHand() {
        for (Hand hand : hands) {
            if (hand.isActionable()) {
                return true;
            }
        }
        return false;
    }

    Hand getActionableHand() {
        for (Hand hand : hands) {
            if (hand.isActionable()) {
                return hand;
            }
        }
        return new Hand();
    }

}
