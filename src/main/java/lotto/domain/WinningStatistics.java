package lotto.domain;

public class WinningStatistics {
    private final double rateOfReturn;

    public WinningStatistics(int totalWinningMoney, int inputMoney) {
        this.rateOfReturn = Math.round(((double) totalWinningMoney / (double) inputMoney * 100) * 10) / 10.;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
