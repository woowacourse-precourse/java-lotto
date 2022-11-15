package lotto.dto;

public class ProfitDto {

    public static final double DEFAULT_RATIO = 10.0;
    private double profit;

    private ProfitDto(double profit) {
        this.profit = Math.round(profit * DEFAULT_RATIO) / DEFAULT_RATIO;
    }

    public static ProfitDto of(double profit) {
        return new ProfitDto(profit);
    }

    public double getProfit() {
        return profit;
    }
}
