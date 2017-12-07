import java.util.Arrays;

class Card {
    Suit suit;
    Rank rank;
    int point;

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

    // boolean isAce() {
    //     return rank.equals(Rank.ACE);
    // }
}
