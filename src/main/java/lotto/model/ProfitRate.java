package lotto.model;

public class ProfitRate {
    final double profitRate;

    public ProfitRate(double profitRate) {
        this.profitRate = profitRate;
    }

    public double getProfitRate() {
        return profitRate;
    }

    @Override
    public String toString() {
        return String.format("%,.1f", this.profitRate);
    }
}
