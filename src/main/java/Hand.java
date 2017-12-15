import java.util.Arrays;
import java.util.ArrayList;

class Hand {

    enum State {
        ACTIONABLE,
        STAND,
        SURRENDERED,
        BLACKJACK,
        LOSTTODEALERBLACKJACK,
        BUSTED;
    }

    private ArrayList<Card> hand;
    private int pointTotal = 0;
    private int elevens = 0;
    private State state;
    private float bet;
    private int numOfDoublings;
    private int numOfCards;

    Hand () {
        hand = new ArrayList<Card>();
        state = State.ACTIONABLE;
    }

    Hand (float bet) {
        hand = new ArrayList<Card>();
        this.bet = bet;
        numOfDoublings = 0;
        state = State.ACTIONABLE;
    }

    boolean isActionable() {
        return state == State.ACTIONABLE;
    }

    int getUpcardPoint() {
        return hand.get(0).getPoint();
    }

    void applyAction(Action action, Shoe shoe, Hands hands) {
        switch (action) {
        case STAND:
            state = State.STAND;
            break;
        case SURRENDER:
            state = State.SURRENDERED;
            break;
        case HIT:
            addCard(shoe.dealCard());
            break;
        case DOUBLE:
            addCard(shoe.dealCard());
            bet *= 2;
            numOfDoublings++;
            break;
        case SPLIT:
            Hand splitHand = new Hand(bet);
            splitHand.addCard(removeCard());
            addCard(shoe.dealCard());
            splitHand.addCard(shoe.dealCard());
            hands.addSplitHand(splitHand);
            break;
        }
    }

    Card removeCard() {
        numOfCards--;
        return hand.remove(0);
    }

    void lostToDealerBlackjack() {
        state = State.LOSTTODEALERBLACKJACK;
    }

    float getBet() {
        return bet;
    }

    boolean hasDoubled() {
        return numOfDoublings > 0;
    }

    int getNumOfDoublings() {
        return numOfDoublings;
    }

    void incrementNumOfDoublings() {
        numOfDoublings++;
    }

    State getState() {
        return state;
    }

    void addCard(Card card) {
        hand.add(card);
        numOfCards++;
        pointTotal += card.getPoint();
        if (card.getRank() == Rank.ACE) {elevens++;}
        if (pointTotal > 21 && elevens > 0) {
            pointTotal -= 10;
            elevens--;
        }
        if (pointTotal == 21 && hand.size() == 2) {
            state = State.BLACKJACK;
        }
        if (pointTotal > 21) {
            state = State.BUSTED;
        }
    }

    void addCard(Suit suit, Rank rank) {
        addCard(new Card(suit, rank));
    }

    void addCard(String suit, String rank) {
        Suit s = Suit.valueOf(suit.toUpperCase());
        Rank r = Rank.valueOf(rank.toUpperCase());
        addCard(s, r);
    }

    int getPointTotal() {
        return pointTotal;
    }

    boolean isSoft() {
        return elevens > 0;
    }

    int getNumOfCards() {
        // return numOfCards;
        return hand.size();
    }

    ArrayList<Card> getCards() {
        return hand;
    }

    boolean isSpaded() {
        for (Card card : getCards()) {
            if (card.getSuit() != Suit.SPADES) {
                return false;
            }
        }
        return true;
    }

    boolean isSuited() {
        Suit suit = getCards().get(0).getSuit();
        for (Card card : getCards()) {
            if (card.getSuit() != suit) {
                return false;
            }
        }
        return true;
    }

    boolean isSoft17() {
        return (isSoft() && getPointTotal() == 17);
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

    boolean has678() {
        return false;
    }

    boolean has777() {
        if (hand.size() == 3) {
            for (Card card : hand) {
                if (!(card.getPoint() == 7)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    boolean isBlackjack() {
        return (hand.size() == 2 && pointTotal == 21);
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
