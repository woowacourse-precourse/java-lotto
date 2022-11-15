package lotto.domain;

import java.util.Arrays;

public class Rate {

    private final double rate;

    public Rate(Money money, PrizeResult prizeResult) {
        this.rate = getAllMoney(prizeResult) / money.getMoney();
    }

    private double getAllMoney(PrizeResult prizeResult) {
        int result = 0;

        for (Prize prize : Prize.values()) {
            result += prizeResult.getPrizeCount(prize) * prize.getMoney();
        }

        return result;
    }
}
