package lotto.service;

import lotto.model.PurchaseAmount;

public class ProfitRateService {
    public static double calculateRate(PurchaseAmount purchaseAmount, double prizeMoney) {
        int purchaseAmountMoney = purchaseAmount.getMoney();
        double profitRate = (prizeMoney / (double) purchaseAmountMoney) * 100;
        return Math.round(profitRate * 10) / 10.0;
    }
}
