package lotto.domain;

public class Profit {

    private PrizeCount prizeCount;

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

    public float getAmount() {
        return amount;
    }
}
