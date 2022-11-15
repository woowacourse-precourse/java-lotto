package lotto.domain.winnings;

import lotto.domain.number.PayOut;
import lotto.domain.rule.Rank;

import java.util.Map;

public class Winnings {
    public static double getYield(PayOut payOut, Map<Rank, Integer> lottoResult) {
        int revenue = 0;
        for (Map.Entry<Rank, Integer> rankIntegerEntry : lottoResult.entrySet()) {
            if (rankIntegerEntry.getValue() > 0) {
                revenue += rankIntegerEntry.getValue() * rankIntegerEntry.getKey().getWinnings();
            }
        }

        return ((double) revenue / (double) payOut.getValueAsInt()) * 100;
    }
}
