import java.util.*;
import java.io.*;
import org.apache.commons.csv.*;

class Strategy {
    private Rules rules;

    Strategy(Rules rules) {
        this.rules = rules;
    }

    // Action getAction(Hand hand, Card card, boolean hasDoubled) {
    // }

    enum StrategyTable {
        H17HARD, H17SOFT, H17PAIR,
        S17HARD, S17SOFT, S17PAIR,
        H17DOUBLEDNOTYET,
        H17DOUBLEDHARD,
        H17DOUBLEDSOFT;
    }

    String getCell(Bet bet, int upCardPoint) {
        ArrayList<String> row = getRow(bet);
        return row.get(upCardPoint - 1);
    }

    ArrayList<String> getRow(Bet bet) {
        StrategyTable strategyTable = pickTable(bet);
        ArrayList<ArrayList<String>> table = getTable(strategyTable);
        String form = bet.getLookupFormat();
        String ptTot = Integer.toString(bet.getPointTotal());
        if (strategyTable == StrategyTable.H17PAIR || strategyTable == StrategyTable.S17PAIR) {
            for (ArrayList<String> row : table) {
                if (row.get(0).equals(form)) {
                    return row;
                }
            }
        } else if (strategyTable == StrategyTable.H17DOUBLEDNOTYET) {
            char c0 = form.charAt(0);
            char c2 = form.charAt(2);
            if (c0 == c2 || c0 == 'A') {
                for (ArrayList<String> row : table) {
                    if (row.get(0).equals(form)) {
                        return row;
                    }
                }
            } else {
                for (ArrayList<String> row : table) {
                    if (row.get(0).equals(ptTot)) {
                        return row;
                    }
                }
            }
        } else {
            for (ArrayList<String> row : table) {
                if (row.get(0).equals(ptTot)) {
                    return row;
                }
            }
        }
        return new ArrayList<String>();
    }

    StrategyTable pickTable(Bet bet) {
        boolean pair = (bet.isPair() && !bet.containsOneOfFollowingPoints(4, 5, 10));
        boolean soft = bet.isSoft();
        boolean doubled = bet.getNumOfDoublings() > 0;
        
        if (rules == Rules.H17) {
            if (pair) {
                return StrategyTable.H17PAIR;
            } else if (soft) {
                return StrategyTable.H17SOFT;
            } else {
                return StrategyTable.H17HARD;
            }
        } else if (rules == Rules.S17) {
            if (pair) {
                return StrategyTable.S17PAIR;
            } else if (soft) {
                return StrategyTable.S17SOFT;
            } else {
                return StrategyTable.S17HARD;
            }
        } else if (doubled) {
            if (soft) {
                return StrategyTable.H17DOUBLEDSOFT;
            } else {
                return StrategyTable.H17DOUBLEDHARD;
            }
        } else {
            return StrategyTable.H17DOUBLEDNOTYET;
        }
    }

    ArrayList<ArrayList<String>> getTable(StrategyTable strategyTable) {
        try {
            Reader in = new FileReader("src/main/resources/" + strategyTable.toString().toLowerCase() + ".csv");
            CSVParser parser = CSVFormat.RFC4180.parse(in);
            ArrayList<ArrayList<String>> table = new ArrayList<ArrayList<String>>();
            for (CSVRecord record : parser) {
                ArrayList<String> row = new ArrayList<String>();
                for (int i = 0; i < record.size(); i++) {
                    String field = record.get(i);
                    row.add(field);
                }
                table.add(row);
            }
            return table;
        } catch (IOException ex) {
            return null;
        }
    }

    String getStrategyString(Bet bet, int upCardPoint) {
        int ptTot = bet.getPointTotal();
        boolean doubled = bet.getNumOfDoublings() > 0;

        if (doubled) {
            if (ptTot >= 12 && ptTot <= 18) {
                if (upCardPoint >= 8) {
                    return "r";
                }
            } else if (ptTot == 17 && upCardPoint == 11) {
                return "r";
            }
        }

        return getCell(bet, upCardPoint);
        // StrategyTable strategyTable = pickTable(isPair, hand.isSoft, doubled);
        // if (!rules.equals(H17REDOUBLE)) {
        //     if (treatAsPairs) {
        //         // use pairs table
        //     } else if (hand.isSoft()) {
        //         // use soft table
        //     } else {
        //         // use hard table
        //     }
        // } else {
        //     if (!hasDoubled) {
        //         if (treatAsPairs) {
        //             // use the pair
        //         } else if (hand.hasAnAce()) {
        //             // look up with ace
        //         } else {
        //             // look up as point total
        //         }
        //     } else if (!hand.isSoft()) {
        //         // use hard table
        //     } else {
        //         // use soft table
        //     }
        // }
    }

    // Rules rules;
    // Card upCard;
    // Hand hand;
    // boolean hasDoubled;

    // Strategy(Rules rules) {
    //     this.rules = rules;
    // }

    // void setUpcard(Card card) {
    //     upCard = card;
    // }

    // Action chooseAction() {
    //     String action =
    //         actionMatrixLookup(rules, hasDoubled, value, hasAce, twins);
    //     char actionChar = action.getCharAt(0);
    //     int digit = getDigits(action);
    //     char specialChar = getSpecialChar(action);

    //     if (hand.size() >= digit) {return Action.HIT;}

    //     if (string.equals("P$") && suitedSevens(hand)) {return Action.HIT;}

    //     if (possible678(hand, specialChar)) {return Action.HIT;}

    //     switch (actionChar) {
    //     case 'H': return Action.HIT;
    //     case 'S': return Action.STAND;
    //     case 'P': return Action.SPLIT;
    //     case 'D': return Action.DOUBLE;
    //     case 'R': return Action.SURRENDER;
    //     }
    // }

    // boolean suitedSevens(Hand hand) {
    //     for (Card card : hand.getCards()) {
    //         if (card.rank != Rank.SEVEN) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // boolean possible678(Hand hand, char specialChar) {
    //     ArrayList sixSevenEight = ArrayList.toList(6, 7, 8);
    //     boolean bool = sixSevenEight.containsAll(hand);
    //     if (bool == true) {
    //         if (specialChar == '*') {
    //             return true;
    //         } else if (specialChar == '\'') {
    //             if (isSuited(hand) || isSpaded(hand)) {
    //                 return true;
    //             } else {
    //                 return false;
    //             }
    //         } else if (specialChar == '"') {
    //             if (spaded(hand)) {
    //                 return true;
    //             }
    //         }
    //     }
    //     return false;
    // }

    // boolean isSpaded() {
    //     for (Card card : hand) {
    //         if (card.suit != Suit.SPADES) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // boolean isSuited() {
    //     Suit suit = hand.get(0);
    //     for (Card card : hand) {
    //         if (card.suit != suit) {
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // int getDigit(String string) {
    //     if (string.contains("4")) {
    //         return 4;
    //     } else if (string.contains("5")) {
    //         return 5;
    //     } else if (string.contains("6")) {
    //         return 6;
    //     }
    //     return Integer.MAX_VALUE;
    // }
            
    // char getSpecialChar(String string) {
    //     if (string.contains("*")) {
    //         return '*';
    //     } else if (string.contains("'")) {
    //         return '\'';
    //     } else if (string.contains("\"")) {
    //         return '"';
    //     }
    // }
}
