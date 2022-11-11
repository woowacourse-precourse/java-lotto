package lotto.model;

public class ProfitRate {
    public final double rate;

    public ProfitRate(PurchaseAmount purchaseAmount, LottoResult lottoResult) {
        double prizeMoney = lottoResult.getPrizeMoney();
        int purchaseAmountMoney = purchaseAmount.getMoney();
        this.rate = calculateRate(purchaseAmountMoney, prizeMoney);
    }

    public double getRate() {
        return rate;
    }

    private static double calculateRate(int purchaseAmountMoney, double prizeMoney) {
        double profit = (prizeMoney / (double) purchaseAmountMoney) * 100;
        return Math.round(profit * 10) / 10.0;
    }
}
