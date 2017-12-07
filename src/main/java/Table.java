class Table {

    private Rules rules;
    private Shoe shoe;

    Table(Rules rules, int numOfDecks) {
        this.rules = rules;
        shoe = new Shoe(numOfDecks);
    }

    void dealHands(Hand dealer, Player player) {
        Card card1 = shoe.dealCard();
        Card card2 = shoe.dealCard();
        Card card3 = shoe.dealCard();
        Card card4 = shoe.dealCard();
        System.out.println("adding " + card1);
        System.out.println("adding " + card2);
        System.out.println("adding " + card3);
        System.out.println("adding " + card4);
        player.addCard(card1);
        dealer.addCard(card2);
        player.addCard(card3);
        dealer.addCard(card4);
    }

    void assessBlackjacks(Hand dealer, Player player) {
        if (player.getPointTotal() == 21) {
            player.increaseMoneyByBet(3 / 2);
            player.popBet();
        } else if (dealer.getPointTotal() == 21) {
            player.increaseMoneyByBet(-1);
            player.popBet();
        }
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < 25; i++) {
            result += shoe.dealCard().toString() + "\n";
        }
        result += shoe.dealCard().toString();
        return result;
    }
}
