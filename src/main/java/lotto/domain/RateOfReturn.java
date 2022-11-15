package lotto.domain;

import lotto.domain.enums.LottoResult;

public class RateOfReturn {
    private final double rateOfReturn;

    public RateOfReturn(LottoResults results, Money money) {
        this.rateOfReturn = calculate(results, money.getMoney());
    }
    
    private double calculate(LottoResults results, int money) {
        int winningAmount = getWinningAmountSum(results);
        return (winningAmount / (double) money) * 100;
    }

    private int getWinningAmountSum(LottoResults results) {
        return results.getResults().stream()
            .mapToInt(LottoResult::getAmount)
            .sum();
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
