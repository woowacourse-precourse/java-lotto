package lotto.model;

public class ProfitRate {
    private final double profitRate;

    public ProfitRate(double profitRate) {
        this.profitRate = profitRate;
    }

    @Override
    public String toString() {
        return String.format("%,.1f", this.profitRate);
    }
}
