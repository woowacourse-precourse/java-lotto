package lotto.domain;

import lotto.constant.Constants;

public class WinningStatistics {
    private final double rateOfReturn;

    public WinningStatistics(int totalWinningMoney, int inputMoney) {
        this.rateOfReturn = Math.round(
                ((double) totalWinningMoney / (double) inputMoney * Constants.PERCENT) * Constants.ROUND_DIGIT
        ) / Constants.ROUND_DIGIT;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
