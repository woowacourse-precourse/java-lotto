package lotto.model;

public class Profit {
    private int rewardAmount;
    private int purchaseAmount;
    private double profitValue;

    public Profit(int rewardAmount, int purchaseAmount) {
        this.rewardAmount = rewardAmount;
        this.purchaseAmount = purchaseAmount;
    }

    public void calcProfitValue() {
        if (purchaseAmount == 0) {
            profitValue = 0;
            return;
        }
        profitValue = Math.floor(((double) rewardAmount / purchaseAmount * 100) * 100) / 100;

    }

    public double getProfitValue() {
        calcProfitValue();
        return profitValue;
    }
}
