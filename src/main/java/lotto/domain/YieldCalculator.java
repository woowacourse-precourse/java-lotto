package lotto.domain;

import lotto.domain.match.MatchResults;

public class YieldCalculator {

    public static float getYield(MatchResults results, int buyMoney) {
        return (float) results.getTotalPrice() / buyMoney;
    }
}
