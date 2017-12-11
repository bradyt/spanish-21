import java.util.*;
import java.io.*;
import org.apache.commons.csv.*;

class Main {

    public static void checkSoft(boolean checkIsSoft, Card... cards) {
        Hand hand = new Hand();
        for (Card card : cards) {
            hand.addCard(card);
        }
        if (checkIsSoft) {
            System.out.println(hand);
            System.out.println(hand.isSoft());
            assert(hand.isSoft());
        } else {
            System.out.println(hand);
            System.out.println(hand.isSoft());
            assert(!hand.isSoft());
        }
    }

    public static void main(String[] args) throws FileNotFoundException, IOException {

        // Strategy strategy = new Strategy(Rules.H17REDOUBLE);
        // Bet bet = new Bet(5);
        // bet.addCard(new Card(Suit.CLUBS, Rank.NINE));
        // bet.addCard(new Card(Suit.CLUBS, Rank.NINE));
        // ArrayList<String> row = strategy.getRow(bet);
        // String cell = strategy.getCell(bet, 5);
        // // ArrayList<ArrayList<String>> table = strategy
        // //     .getTable(strategy.pickTable(bet));

        // System.out.println(row.toString());
        // System.out.println(cell);

        // boolean pair = false;
        // boolean soft = false;
        // boolean doubled = false;

        // String string = strategy.getString(pair, soft, doubled);
        // System.out.println(string);


        // String lookup(String hand, String upCard) {


        // Dealer dealer = new Dealer(Rules.H17REDOUBLE, new Shoe(5));

        // dealer.shuffle();

        // dealer.addPlayer(100);

        // dealer.getPlayer().addBet(5);

        // dealer.dealHands();

        // dealer.assessBlackjacks();

        // while (dealer.getPlayer().hasActionableBets()) {
        //     // tricky part
        //     break;
        // }

        // dealer.takesTurn();

        // dealer.assessPayouts();

        // System.out.println("# player has " + player.getPointTotal());
        // System.out.println(dealer);
        // System.out.println(table);

        // for (Card card : dealer.getCards()) {
        //     System.out.println(card);
        // }


        // System.out.println("# player has " + player.getPointTotal());

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


    }
}
