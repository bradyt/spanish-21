class Round {

    static float playRound(Shoe shoe, Rules rules, Strategy strategy, float bet) {

        Hand player = new Hand(bet);
        Hand dealer = new Hand();
        int numOfSplits = 0;
        float deltaMoney = 0;
        boolean canSplit = true;
        boolean hasSplit;

        deal(shoe, dealer, player);

        if (dealer.isBlackjack()) {
            if (player.isActionable()) {
                player.lostToDealerBlackjack();
            }
        }

        Hands hands = new Hands();
        hands.addHand(player);

        int upcardPoint = dealer.getUpcardPoint();

        Hand currentHand = new Hand();
        while (hands.hasActionableHand()) {
            currentHand = hands.getActionableHand();
            Action action =
                strategy.getAction(dealer, currentHand, numOfSplits < 3);
            if (action == Action.SPLIT) {numOfSplits++;}
            // TODO: check that applyAction is doing the right thing
            currentHand.applyAction(action, shoe, hands);
        }

        hasSplit = numOfSplits > 0;

        for (Hand hand : hands.getHands()) {
            // TODO: write tests
            deltaMoney += Payout.calculatePayout(dealer, hand, hasSplit);
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
