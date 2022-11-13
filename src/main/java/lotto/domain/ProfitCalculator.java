package lotto.domain;

public class ProfitCalculator {
    public String profitPercent(double money, double profit) {
        double input = (profit*100)/money;
        return String.format("%.1f", input);
    }
}
