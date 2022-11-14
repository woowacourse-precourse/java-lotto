package lotto.model;

public class EarningRate {
    private final int money;

    public EarningRate(int money) {
        this.money = money;
    }

    public double computeEarningRate(long winnings) {
        double earningRate = (winnings / (double) money) * 100.0;
        earningRate = Math.round(earningRate * 10) / 10.0;
        return earningRate;
    }
}
