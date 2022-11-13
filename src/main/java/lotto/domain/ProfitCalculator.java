package lotto.domain;

import java.util.List;

public class ProfitCalculator {

    public float getRateOfReturn(List<Integer> sumOfResult) {
        int amount = 0;
        float sum = 0;
        int[] prizeMoney = {5_000, 50_000, 1_500_000, 30_000_000, 2_000_000_000};
        for (int i = 0; i < sumOfResult.size(); i++) {
            if (i == sumOfResult.size() - 1) {
                amount = sumOfResult.get(i);
                continue;
            }
            sum += sumOfResult.get(i) * prizeMoney[i];
        }
        return sum / (amount * Lotto.PRICE) * 100;
    }
}


