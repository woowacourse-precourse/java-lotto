package lotto.domain;

import lotto.domain.match.Results;

public class YieldCalculator {

    public static float getYield(Results results, int buyMoney) {
        return (float) results.getTotalPrice() / buyMoney;
    }
}
