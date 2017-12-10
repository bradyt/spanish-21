class Dealer {

    private Rules rules;
    private Shoe shoe;
    private Hand hand;
    private Player player;

    Dealer(Rules rules, Shoe shoe) {
        this.rules = rules;
        this.shoe = shoe;
        hand = new Hand();
    }

    void shuffle() {
        shoe.shuffle();
    }

    void addPlayer(int money) {
        player = new Player(money);
    }

    Player getPlayer() {
        return player;
    }

    void dealHands() {
        player.addCard(shoe.dealCard());
        hand.addCard(shoe.dealCard());
        player.addCard(shoe.dealCard());
        hand.addCard(shoe.dealCard());
    }

    void assessBlackjacks() {
        if (player.getPointTotal() == 21) {
            System.out.println(player.getMoney());
            player.increaseMoneyByBet((float)1.5);
            player.popBet();
            System.out.println("player has blackjack");
            System.out.println(player.getMoney());
        } else if (hand.getPointTotal() == 21) {
            System.out.println(player.getMoney());
            player.increaseMoneyByBet(-1);
            player.popBet();
            System.out.println("dealer has blackjack");
            System.out.println(player.getMoney());
        }
    }

    void takesTurn() {
        while (hand.getPointTotal() <= 16 || (hand.isSoft17() && !rules.equals(Rules.S17))) {
            hand.addCard(shoe.dealCard());
        }
    }

    void assessPayouts() {
        // another tricky part
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
