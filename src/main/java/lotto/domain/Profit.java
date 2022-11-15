package lotto.domain;

import lotto.util.NumberUtils;

public class Profit {

    private final PrizeCount prizeCount;

    private final int purchaseAmount;
    private float amount;
    private float rate;

    public Profit(PrizeCount prizeCount, int purchaseAmount) {
        this.prizeCount = prizeCount;
        this.purchaseAmount = purchaseAmount;
    }

    public void calculate() {
        calculateAmount();
        calculateRate();
    }

    public void calculateAmount() {
        for (Prize prize : Prize.values()) {
            amount += prizeCount.getTotalMoney(prize);
        }
    }

    public void calculateRate() {
        rate = (amount / purchaseAmount) * 100;
    }

    public void printRate() {
        StringBuilder message = new StringBuilder();

        message.append("총 수익률은 ")
                .append(NumberUtils.roundToTwoDecimalPlaces(rate))
                .append("%")
                .append("입니다.");

        System.out.println(message);
    }

}
