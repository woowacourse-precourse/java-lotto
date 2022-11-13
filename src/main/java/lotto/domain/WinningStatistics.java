package lotto.domain;

public class WinningStatistics {
    private final double rateOfReturn;

    public WinningStatistics(int totalWinningMoney, int inputMoney) {
        this.rateOfReturn = inputMoney;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
