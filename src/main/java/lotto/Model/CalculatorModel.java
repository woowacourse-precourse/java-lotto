package lotto.Model;

import lotto.Cash;

public class CalculatorModel {
    private final static int MIN_UNIT = 1000;

    public double getProfit(int totalPrize, int investmentCash) {
        double profit = ((double) totalPrize / investmentCash) * 100 * 10;
        profit = Math.round(profit);

        return profit / 10;
    }

    public int countLottoNumber(Cash cash) {
        return cash.getCash() / MIN_UNIT;
    }
}
