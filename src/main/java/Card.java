import java.util.Arrays;

class Card {
    private Suit suit;
    private Rank rank;
    private int point;

    Card (Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
        if (rank.equals(Rank.ACE)) {
            point = 11;
        } else if (Arrays.asList(Rank.JACK, Rank.QUEEN, Rank.KING).contains(rank)) {
            point = 10;
        } else {
            point = rank.ordinal() + 2;
        }
    }

    Suit getSuit() {
        return suit;
    }

    Rank getRank() {
        return rank;
    }

    String getLookupFormat() {
        if (point == 11) {
            return "A";
        } else {
            return Integer.toString(point);
        }
    }

    int getPoint() {
        return point;
    }
    
    public String toString() {
        return rank.toString().toLowerCase() + " of " + suit.toString().toLowerCase();
    }
}
