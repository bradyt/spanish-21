import java.util.*;
import java.io.*;
import org.apache.commons.csv.*;

class Strategy {
    private Rules rules;
    private Map<StrategyTable, ArrayList<ArrayList<String>>> tableMap;

    Strategy(Rules rules) {
        this.rules = rules;
        tableMap = cacheTables();
    }

    Action getAction(int upcardPoint, Hand hand, boolean canSplit) {

        String action = getStrategyString(hand, upcardPoint);

        char actionChar = action.toUpperCase().charAt(0);
        int digit = getDigit(action);
        char specialChar = getSpecialChar(action);

        if (hand.getCards().size() >= digit) {return Action.HIT;}
        if (possible678AgainstSpecialChar(hand, specialChar)) {
            return Action.HIT;
        }
        if (action.equals("p$") && isSuited(hand)) {return Action.HIT;}

        switch (actionChar) {
        case 'H': return Action.HIT;
        case 'S': return Action.STAND;
        case 'P': return Action.SPLIT;
        case 'D': return Action.DOUBLE;
        case 'R': return Action.SURRENDER;
        }
        return Action.HIT;
    }

    boolean possible678(Hand hand) {
        int pt0 = hand.getCards().get(0).getPoint();
        int pt1 = hand.getCards().get(1).getPoint();
        if (pt0 == 6 && pt1 == 7 || pt1 == 8) {
            return true;
        }
        if (pt0 == 7 && pt1 == 6 || pt1 == 8) {
            return true;
        }
        if (pt0 == 8 && pt1 == 6 || pt1 == 7) {
            return true;
        }
        return false;
    }
 
    boolean possible678AgainstSpecialChar(Hand hand, char specialChar) {
        List<Integer> sixSevenEight = Arrays.asList(6, 7, 8);
        boolean bool = possible678(hand);
        if (bool == true) {
            if (specialChar == '*') {
                return true;
            } else if (specialChar == '\'') {
                if (isSuited(hand) || isSpaded(hand)) {
                    return true;
                } else {
                    return false;
                }
            } else if (specialChar == '"') {
                if (isSpaded(hand)) {
                    return true;
                }
            }
        }
        return false;
    }
 
    boolean isSpaded(Hand hand) {
        for (Card card : hand.getCards()) {
            if (card.getSuit() != Suit.SPADES) {
                return false;
            }
        }
        return true;
    }

    boolean isSuited(Hand hand) {
        Suit suit = hand.getCards().get(0).getSuit();
        for (Card card : hand.getCards()) {
            if (card.getSuit() != suit) {
                return false;
            }
        }
        return true;
    }

    int getDigit(String string) {
        if (string.contains("4")) {
            return 4;
        } else if (string.contains("5")) {
            return 5;
        } else if (string.contains("6")) {
            return 6;
        }
        return Integer.MAX_VALUE;
    }
            
    char getSpecialChar(String string) {
        if (string.contains("*")) {
            return '*';
        } else if (string.contains("'")) {
            return '\'';
        } else if (string.contains("\"")) {
            return '"';
        }
        return 0;
    }

    enum StrategyTable {
        H17HARD, H17SOFT, H17PAIR,
        S17HARD, S17SOFT, S17PAIR,
        H17DOUBLEDNOTYET,
        H17DOUBLEDHARD,
        H17DOUBLEDSOFT;
    }

    String getCell(Hand hand, int upCardPoint) {

        // System.out.println(hand);
        // System.out.println(upCardPoint);

        ArrayList<String> row = getRow(hand);

        // System.out.println(row);

        return row.get(upCardPoint - 1);

    }

    ArrayList<String> getRow(Hand hand) {
        StrategyTable strategyTable = pickTable(hand);
        ArrayList<ArrayList<String>> table = getCachedTable(strategyTable);
        String form = hand.getLookupFormat();
        String ptTot = Integer.toString(hand.getPointTotal());
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

    StrategyTable pickTable(Hand hand) {
        boolean pair = (hand.isPair() && !hand.containsOneOfFollowingPoints(4, 5, 10));
        boolean soft = hand.isSoft();
        boolean doubled = hand.getNumOfDoublings() > 0;
        
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

    ArrayList<ArrayList<String>> getCachedTable(StrategyTable strategyTable) {
        return tableMap.get(strategyTable);
    }

    Map<StrategyTable, ArrayList<ArrayList<String>>> cacheTables() {
        tableMap = new HashMap<StrategyTable, ArrayList<ArrayList<String>>>();
        for (StrategyTable strategyTable : StrategyTable.values()) {
            tableMap.put(strategyTable, getTable(strategyTable));
        }
        return tableMap;
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

    String getStrategyString(Hand hand, int upCardPoint) {
        int ptTot = hand.getPointTotal();
        boolean doubled = hand.getNumOfDoublings() > 0;

        if (doubled) {
            if (ptTot >= 12 && ptTot <= 18) {
                if (upCardPoint >= 8) {
                    return "r";
                }
            } else if (ptTot == 17 && upCardPoint == 11) {
                return "r";
            }
        }

        return getCell(hand, upCardPoint);
    }

}
