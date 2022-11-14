package lotto.domain;

public class RewardCalculator {

    private double createProfitInFirstDecimal(long totalRevenue, long price) {
        double profit = (double) totalRevenue / price * 100;

        return Math.round(profit * 10) / (double) 10;
    }
}
