package lotto.vo;

public class Profit {
    private final double profit;

    public Profit(double profit) {
        this.profit = profit;
    }

    public Profit convertToPercentage() {
        return new Profit(profit * 100);
    }

    public Profit roundToFirstDigit() {
        return new Profit(Math.round(profit * 10) / 10.0);
    }

    public double getValue() {
        return profit;
    }

    @Override
    public String toString() {
        return String.valueOf(profit);
    }
}
