package lotto.domain;

import java.util.List;

public class ProfitCalculator {
    private static final int PERCENTAGE = 100;
    private static final int AMOUNT_INDEX = 5;

    public float toRateOfProfit(List<Integer> result) {
        int expense = result.get(AMOUNT_INDEX) * Lotto.PRICE;
        int income = 0;
        int index = 0;
        for(Grade grade : Grade.values()){
            income += result.get(index++) * grade.getMoney();
        }
        return (float) (income) / expense * PERCENTAGE;
    }
}
