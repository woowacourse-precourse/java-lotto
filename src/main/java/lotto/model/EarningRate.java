package lotto.model;

public class EarningRate {
    private final int money;

    public EarningRate(int money) {
        this.money = money;
    }

    public double computeEarningRate(long winnings) {
        double earningRate = (winnings / (double) money) * 100.0;
        return earningRate;
    }
}
