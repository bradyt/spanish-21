import java.util.List;
import java.util.ArrayList;

class Hands {

    private ArrayList<Hand> hands;

    Hands() {
        hands = new ArrayList<Hand>();
    }

    void addHand(Hand hand) {
        hands.add(hand);
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
