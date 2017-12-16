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

        int upcard = dealer.getUpcardPoint();

        Hand currentHand;
        Action action;
        while (hands.hasActionableHand()) {
            currentHand = hands.getActionableHand();
            action = strategy.getAction(upcard, currentHand, hands.canSplit());
            // if (currentHand.getPointTotal() < 17) {
            //     action = Action.HIT;
            // } else if (currentHand.getPointTotal() == 17 && currentHand.isSoft()) {
            //     action = Action.HIT;
            // } else {
            //     action = Action.STAND;
            // }
            currentHand.applyAction(action, shoe, hands);
        }
      
        dealersTurn(rules, shoe, dealer);

        int dealersPointTotal = dealer.getPointTotal();
        boolean hasSplit = hands.hasSplit();
        for (Hand hand : hands.getHands()) {
            deltaMoney += Payout.calculatePayout(upcard, dealersPointTotal, hand, hasSplit);
        }

        return deltaMoney;
    }

    static void deal(Shoe shoe, Hand dealer, Hand hand) {
        hand.addCard(shoe.dealCard());
        dealer.addCard(shoe.dealCard());
        hand.addCard(shoe.dealCard());
        dealer.addCard(shoe.dealCard());
    }

    static void dealersTurn(Rules rules, Shoe shoe, Hand dealer) {
        while (dealer.getPointTotal() < 17) {
            dealer.addCard(shoe.dealCard());
        }
        if (rules != Rules.S17 && dealer.getPointTotal() == 17 && dealer.isSoft()) {
            dealer.addCard(shoe.dealCard());
        }
    }
}
