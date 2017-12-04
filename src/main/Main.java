// import java.util.Array;
// import java.util.ListArray;

class Main {

    public static void main(String[] args) {

        Deck deck = new Deck(5);

        deck.shuffle();

        Hand hand = new Hand();

        hand.addCard(deck.dealCard());
        hand.addCard(deck.dealCard());

        System.out.println(hand.getValue());

        for (Card card : hand.getCards()) {
            System.out.print(card.rank.toString().toLowerCase());
            System.out.print(" of ");
            System.out.println(card.suit.toString().toLowerCase());
            System.out.print("point is ");
            System.out.println(card.point);
        }
            

        // Card card = deck.dealCard();
        // System.out.print(card.rank.toString().toLowerCase());
        // System.out.print(" of ");
        // System.out.println(card.suit.toString().toLowerCase());
        // System.out.print("point is ");
        // System.out.println(card.point);

    }
}
