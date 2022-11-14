package lotto.service;

import lotto.domain.Rank;

import java.util.List;

public class Calculator {
    public static double getYield(List<Rank> ranks, int quantity) {
        int totalReward = 0;

        for (Rank rank : ranks) {
            totalReward += rank.getTotalReward();
        }

        double yield = totalReward / (double) Convertor.getAmount(quantity);
        return (Math.round(yield * 10000)/100.0);
    }
}
