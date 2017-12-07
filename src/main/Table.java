class Table {

    private Rules rules;
    private Shoe shoe;

    Table(Rules rules, int numOfDecks) {
        this.rules = rules;
        shoe = new Shoe(numOfDecks);
    }

    void dealHands(Hand dealer, Player player) {
        player.addCard(shoe.dealCard());
        dealer.addCard(shoe.dealCard());
        player.addCard(shoe.dealCard());
        player.addCard(shoe.dealCard());
    }

    void assessBlackjacks(Hand dealer, Player player) {
        if (player.getValue() == 21) {
            player.increaseMoneyByBet(3 / 2);
            player.popBet();
        } else if (dealer.getValue() == 21) {
            player.increaseMoneyByBet(-1);
            player.popBet();
        }
    }
}
