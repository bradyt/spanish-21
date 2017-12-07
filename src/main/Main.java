class Main {

    public static void main(String[] args) {

        Table table = new Table(Rules.H17REDOUBLE, 5);
        Hand dealer = new Hand();
        Player player = new Player(100);

        player.addBet(5);

        table.dealHands(dealer, player);

        table.assessBlackjacks(dealer, player);

        // while (player.hasActionableBets()) {
        //     Bet bet = player.popBet();
        //     action Action = Action.STAND;
        //     switch (action) {
        //     case Action.HIT: 
        //         table.hitOn(bet);
        //         bet.addCard(shoe.dealCard());
        //         if (heb
        //         if (hand.getValue() > 21) {
        //             player.money -= hand.bet;
        //             if (player.splitHands().isEmpty()) {
        //                 break;
        //             } else {
        //                 hand = splitHands.remove(0);
        //             }
        //         }
        //     case Action.STAND:
        //         player.stoodHands.add(hand);
        //         if (player.splitHands().isEmpty()) {
        //             break;
        //         } else {
        //             hand = splitHands.remove(0);
        //         }
        //     case Action.DOUBLE:
        //         hand.bet *= 2;
        //         hand.addCard(shoe.dealCard());
        //         if (hand.getValue() > 21) {
        //             player.money -= hand.bet;
        //             if (player.splitHands().isEmpty()) {
        //                 break;
        //             } else {
        //                 hand = splitHands.remove(0);
        //             }
        //         } else {
        //             hand.numOfDoublings *= 2;
        //         }
        //     case Action.SPLIT:
        //         Hand newHand = hand.duplicateHand());

        //         player.splitHands.add(
        //     case Action.SURRENDER:
        //         player.money -= hand.bet;
        //     }
        // }

        // while (true) { // while dealer needs cards
        //     if (dealer.getValue() <= 16) {
        //         dealer.addCard(shoe.dealCard());
        //     } else if (dealer.getValue() > 17 || rules.equals(Rules.S17)) {
        //         break;
        //     } else if (dealer.isSoft()) {
        //         dealer.addCard(shoe.dealCard());
        //     } else break;
        // }
        // if (dealersHand > playersHand) {
        //     player.loses();
        // } else {
        //     player.wins();
        // }
            /*
              we have an action class, that will determine
              which of
                hit,
                stand,
                double,
                split,
                surrender
              we will do here.

              player also needs to declare the bet.
              player should look at cards, and dealers upcards

              then game should react to player's choice
              if they hit, a card is dealt, and

            */



        /*
          a game starts with:

          rules
          5 decks of cards
          a dealer and some number of players
          deck is shuffled
          dealer and player have hands instantiated
          cards are dealt to player and dealer
          blackjack is checked for
          then for each player, and for each of their hands
          we check for hit, stand, etc, until loop is broken
          then for the dealer, and each of their hands
          we check for hit, stand, etc, until loop is broken
         */


        // System.out.println("# player has " + playersHand.getValue());

        // for (Card card : playersHand.getCards()) {
        //     System.out.print(card.rank.toString().toLowerCase());
        //     System.out.print(" of ");
        //     System.out.println(card.suit.toString().toLowerCase());
        //     System.out.print("point is ");
        //     System.out.println(card.point);
        // }
        // System.out.println("# dealer has " + dealersHand.getValue());
        // for (Card card : dealersHand.getCards()) {
        //     System.out.print(card.rank.toString().toLowerCase());
        //     System.out.print(" of ");
        //     System.out.println(card.suit.toString().toLowerCase());
        //     System.out.print("point is ");
        //     System.out.println(card.point);
        // }


        // Card card = shoe.dealCard();
        // System.out.print(card.rank.toString().toLowerCase());
        // System.out.print(" of ");
        // System.out.println(card.suit.toString().toLowerCase());
        // System.out.print("point is ");
        // System.out.println(card.point);

    }
}
