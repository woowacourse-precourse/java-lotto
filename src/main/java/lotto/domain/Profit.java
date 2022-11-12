package lotto.domain;

public class Profit {

    private final PrizeCount prizeCount;

    private float amount;
    private float rate;

    public Profit(PrizeCount prizeCount) {
        this.prizeCount = prizeCount;
    }

    public void calculate() {
        for (Prize prize : Prize.values()) {
            amount += prizeCount.getTotalPrizeMoney(prize);
        }
    }

    public void setRate(int purchaseAmount) {
        rate = (amount / purchaseAmount) * 100;
    }

    public String getRate() {
        return String.format("%.1f", rate);
    }
}
