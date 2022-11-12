package lotto.domain.yield;

public class Yield {

    private final double percent;

    private Yield(double percent) {
        this.percent = percent;
    }

    public static Yield calculate(final int principal, final int totalReword) {
        // 수익률은 (당첨금 / 원금) * 100
        return new Yield(((double)totalReword / principal) * 100);
    }

    public double getPercent() {
        return percent;
    }
}
