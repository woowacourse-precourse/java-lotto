package lotto.domain;

import java.util.List;

public class ProfitCalculator {
    public static double getProfit(List<Result> results) {
        int revenue = 0;
        double invest = 0;
        return (revenue / invest) * 100;
    }
}
