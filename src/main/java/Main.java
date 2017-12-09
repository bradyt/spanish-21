import java.io.File;
import java.io.Reader;
import java.io.FileReader;
import org.apache.commons.csv.*;

class Main {

    public static void main(String[] args) {

        // File f = new File("src/main/resources/h17-hard.csv");
        // System.out.println(f.exists());
        // System.out.println(System.getProperty("user.dir"));

        Reader in = new FileReader("src/main/resources/h17-hard.csv");
        Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
        for (CSVRecord record : records) {
            System.out.println(records);
        }

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
