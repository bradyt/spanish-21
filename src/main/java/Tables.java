import java.util.*;
import java.io.*;
import org.apache.commons.csv.*;
import com.google.common.collect.*;

class Tables {
 
    private Map<StrategyTable, Table<Integer, Integer, String>> tables;

    Tables() {
        tables = new HashMap<StrategyTable, Table<Integer, Integer, String>>();
        for (StrategyTable strategyTable : StrategyTable.values()) {
            tables.put(strategyTable, ioGetTable(strategyTable));
        }
    }

    String getCell(Rules rules, int upcard, Hand hand) {
        boolean treatAsPair = hand.isPair() && hand.not4510();
        StrategyTable strategyTable = pickTable(rules, hand, treatAsPair);
        Table<Integer, Integer, String> table = getTable(strategyTable);

        int rowLookup = hand.getPointTotal();
        // System.out.println("ptTot is " + rowLookup);
        if (treatAsPair) {
            if (rowLookup == 12 && hand.isSoft()) {
                rowLookup = 11;
            } else {
                rowLookup /= 2;
            }
        }
        // System.out.println(hand.isPair());
        // System.out.println(strategyTable);
        // System.out.println(rowLookup + " " + upcard);
        return table.get(rowLookup, upcard);
    }

    enum StrategyTable {
        H17HARD, H17SOFT, H17PAIR,
        S17HARD, S17SOFT, S17PAIR,
        H17DOUBLEDNOHARD,
        H17DOUBLEDNOSOFT,
        H17DOUBLEDNOPAIR,
        H17DOUBLEDYESHARD,
        H17DOUBLEDYESSOFT;
    }


    StrategyTable pickTable(Rules rules, Hand hand, boolean treatAsPair) {
        boolean doubled = hand.hasDoubled();
        boolean soft = hand.isSoft();

        if (rules == Rules.H17REDOUBLE) {
            if (doubled) {
                if (soft) {
                    return StrategyTable.H17DOUBLEDYESSOFT;
                } else {
                    return StrategyTable.H17DOUBLEDYESHARD;
                }
            } else if (treatAsPair) {
                return StrategyTable.H17DOUBLEDNOPAIR;
            } else if (soft) {
                return StrategyTable.H17DOUBLEDNOSOFT;
            } else {
                return StrategyTable.H17DOUBLEDNOHARD;
            }
        } else if (rules == Rules.H17) {
            if (treatAsPair) {
                return StrategyTable.H17PAIR;
            } else if (soft) {
                return StrategyTable.H17SOFT;
            } else {
                return StrategyTable.H17HARD;
            }
        } else if (rules == Rules.S17) {
            if (treatAsPair) {
                return StrategyTable.S17PAIR;
            } else if (soft) {
                return StrategyTable.S17SOFT;
            } else {
                return StrategyTable.S17HARD;
            }
        }
        return null;
    }

    Table<Integer, Integer, String> getTable(StrategyTable strategyTable) {
        return tables.get(strategyTable);
    }

    Table<Integer, Integer, String> ioGetTable(StrategyTable strategyTable) {
        try {
            Reader in = new FileReader("src/main/resources/" + strategyTable.toString().toLowerCase() + ".csv");
            CSVParser parser = CSVFormat.RFC4180.parse(in);
            Table<Integer, Integer, String> table = HashBasedTable.create();
            for (CSVRecord record : parser) {
                int rowLookup = Integer.parseInt(record.get(0));
                for (int upcard = 2; upcard <= 11; upcard++) {
                    table.put(rowLookup, upcard, record.get(upcard - 1));
                }
            }
            return table;
        } catch (IOException ex) {
            return null;
        }
    }
}
