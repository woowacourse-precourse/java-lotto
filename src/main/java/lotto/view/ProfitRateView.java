package lotto.view;

import lotto.model.LottoResult;
import lotto.model.PurchaseAmount;

public class ProfitRateView {
    public void outPut(PurchaseAmount purchaseAmount, LottoResult lottoResult) {
        double prizeMoney = lottoResult.getPrizeMoney();
        int money = purchaseAmount.getMoney();

        double profit = calculateProfit(money, prizeMoney);
        System.out.println("총 수익률은" + profit + "입니다.");
    }

    private double calculateProfit(int money, double prizeMoney) {
        double profit = (prizeMoney / (double) money) * 100;
        return Math.round(profit * 10) / 10.0;
    }
}
