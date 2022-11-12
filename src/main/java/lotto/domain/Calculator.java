package lotto.domain;

import java.util.List;

public class Calculator {
    public static double getYield(List<Rank> ranks, int quantity) {
        int totalReward = 0;

        for (Rank rank : ranks) {
            totalReward += rank.getTotalReward();
        }

        double yield = totalReward / Convertor.getAmount(quantity);
        return (Math.round(yield * 100)/100.0);
    }
}
