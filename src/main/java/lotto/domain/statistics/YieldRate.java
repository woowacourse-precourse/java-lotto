package lotto.domain.statistics;

public class YieldRate {
    private static final char RATE = '%';
    private final double yieldRate;

    public YieldRate(int calculateAmount, long amountSum) {
        this.yieldRate = (double) amountSum / calculateAmount * 100;
    }

    @Override
    public String toString() {
        return String.format("총 수익률은 %,.1f%c입니다.", this.yieldRate, RATE);
    }
}
