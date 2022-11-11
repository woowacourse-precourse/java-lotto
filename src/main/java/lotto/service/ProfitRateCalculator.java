package lotto.service;

public class ProfitRateCalculator {
    public static double calculate(int purchaseAmountMoney, double prizeMoney) {
        double profit = (prizeMoney / (double) purchaseAmountMoney) * 100;
        return Math.round(profit * 10) / 10.0;
    }
}
