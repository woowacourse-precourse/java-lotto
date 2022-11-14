package lotto.domain;

import lotto.domain.match.MatchResults;

public class YieldCalculator {

    private YieldCalculator() {
    }

    public static double getYield(MatchResults results, int buyMoney) {
        return (double) results.getTotalPrice() / buyMoney;
    }
}
