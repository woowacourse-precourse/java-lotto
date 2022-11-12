package lotto.domain;

public class ProfitCalculator {
    public static double getProfit(int invest, int revenue) {
        return (revenue / (double)invest) * 100;
    }
}
