package lotto.service;

public class ProfitRateService {
    public static double calculateRate(int purchaseAmountMoney, double prizeMoney) {
        double profitRate = (prizeMoney / (double) purchaseAmountMoney) * 100;
        return Math.round(profitRate * 10) / 10.0;
    }
}
