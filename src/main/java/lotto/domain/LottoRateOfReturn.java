package lotto.domain;

import lotto.domain.enums.LottoResult;

import java.util.List;

public class LottoRateOfReturn {
    private final double rateOfReturn;

    public LottoRateOfReturn(List<LottoResult> results, Money money) {
        this.rateOfReturn = calculate(results, money.getMoney());
    }
    
    private double calculate(List<LottoResult> results, int money) {
        int winningAmount = getWinningAmount(results);
        return (winningAmount / (double) money) * 100;
    }

    private int getWinningAmount(List<LottoResult> results) {
        int winningAmount = 0;
        for (LottoResult result : results) {
            winningAmount += result.getAmount();
        }
        return winningAmount;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
