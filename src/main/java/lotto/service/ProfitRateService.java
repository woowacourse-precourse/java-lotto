package lotto.service;

public class ProfitRateService {
    public static double calculateRate(int purchaseAmount, double prizeMoney) {
        double profitRate = (prizeMoney / (double) purchaseAmount) * 100;
        return Math.round(profitRate * 10) / 10.0;
    }
}
