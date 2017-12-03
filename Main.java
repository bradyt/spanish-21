
public class Main {
    // class Card {
    //     Suit suit;
    //     Rank rank;
    // }
    public enum Suit {HEARTS, SPADES, DIAMONDS, CLUBS};
    public enum Rank {
        TWO,
        THREE,
        FOUR,
        FIVE,
        SIX,
        SEVEN,
        EIGHT,
        NINE,
        TEN,
        JACK,
        QUEEN,
        KING,
        ACE;
    };

    public static void main(String[] args) {
        for (Suit suit : Suit.values()) {
            System.out.println(suit);
        }
        for (Rank rank : Rank.values()) {
            System.out.println(rank);
        }
        // for (Card card : Card.values()) {
        //     System.out.println(card);
        // }
    }
}
