package lotto.domain;

import lotto.util.NumberUtils;

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
            amount += prizeCount.getTotalMoney(prize);
        }
    }

    public void calculateRate(int purchaseAmount) {
        rate = (amount / purchaseAmount) * 100;
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();

        message.append("총 수익률은 ")
                .append(NumberUtils.roundToTwoDecimalPlaces(rate))
                .append("%")
                .append("입니다.");

        return message.toString();
    }
}
