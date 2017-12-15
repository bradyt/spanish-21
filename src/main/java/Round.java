class Round {

    static float playRound(Shoe shoe, Rules rules, Strategy strategy, float bet) {

        Hand player = new Hand(bet);
        Hand dealer = new Hand();
        float deltaMoney = 0;

        deal(shoe, dealer, player);

        if (dealer.isBlackjack()) {
            if (player.isActionable()) {
                player.lostToDealerBlackjack();
            }
        }

        Hands hands = new Hands();
        hands.addFirstHand(player);

        int upcardPoint = dealer.getUpcardPoint();

        Hand currentHand = new Hand();
        while (hands.hasActionableHand()) {
            currentHand = hands.getActionableHand();
            Action action = strategy.getAction(upcardPoint, currentHand, hands.canSplit());
            currentHand.applyAction(action, shoe, hands);
        }

        int dealersPointTotal = dealer.getPointTotal();
        for (Hand hand : hands.getHands()) {
            deltaMoney += Payout.calculatePayout(upcardPoint,
                                                 dealersPointTotal,
                                                 hand,
                                                 hands.hasSplit());
        }

        return deltaMoney;
    }

    static void deal(Shoe shoe, Hand dealer, Hand hand) {
        hand.addCard(shoe.dealCard());
        dealer.addCard(shoe.dealCard());
        hand.addCard(shoe.dealCard());
        dealer.addCard(shoe.dealCard());
    }
}
