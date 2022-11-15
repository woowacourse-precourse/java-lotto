package lotto.domain.statistics;

import static lotto.value.RateValue.PERCENT;

public class YieldRate {

    private final int calculateAmount;
    private final long amountSum;

    public YieldRate(int calculateAmount, long amountSum) {
        this.calculateAmount = calculateAmount;
        this.amountSum = amountSum;
    }

    public YieldRate calcYieldRate(int calculateAmount, long amountSum) {
        return new YieldRate(calculateAmount, amountSum);
    }

    public double rate() {
        return (double) amountSum / calculateAmount * PERCENT.getPercentage();
    }

    @Override
    public String toString() {
        return String.format("%,.1f%s", rate(), PERCENT.getRateChar());
    }
}
