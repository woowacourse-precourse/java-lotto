package lotto.domain.statistics;

public class YieldRate {
    private static final char RATE = '%';
    private final int calculateAmount;
    private final long amountSum;

    public YieldRate(int calculateAmount, long amountSum) {
        this.calculateAmount = calculateAmount;
        this.amountSum = amountSum;
    }

    public double rate() {
        return (double) amountSum / calculateAmount * 100;
    }

    @Override
    public String toString() {
        return String.format("%,.1f%c", rate(), RATE);
    }
}
