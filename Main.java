
class Main {

    public static void main(String[] args) {

        Deck deck = new Deck(1);

        int n = deck.size();
        deck.shuffle();

        System.out.println(n);

        // int i = 0;
        // while (i < n) {
        //     Card card = deck.dealCard();
        //     System.out.print(card.rank.toString().toLowerCase());
        //     System.out.print(" of ");
        //     System.out.println(card.suit.toString().toLowerCase());
        //     System.out.println(deck.size());
        //     i++;
        // }

    }
}
