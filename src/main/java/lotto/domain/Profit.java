package lotto.domain;

public class Profit {

    private final PrizeCount prizeCount;

    private float amount;
    private float rate;

    public Profit(PrizeCount prizeCount) {
        this.prizeCount = prizeCount;
    }

    public void calculate(int purchaseAmount) {
        calculateAmount();
        calculateRate(purchaseAmount);
    }

    public void calculateAmount() {
        for (Prize prize : Prize.values()) {
            amount += prizeCount.getTotalPrizeMoney(prize);
        }
    }

    public void calculateRate(int purchaseAmount) {
        rate = (amount / purchaseAmount) * 100;
    }

}
