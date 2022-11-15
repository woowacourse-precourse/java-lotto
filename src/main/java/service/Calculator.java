package service;

import common.regulation.NumberRule;
import domain.Rank;
import exception.InputException;

import java.util.List;

public class Calculator {

    public static int getQuantity(String input) {
        InputException.validateInputAmount(input);

        int total = Integer.parseInt(input);
        int oneLottoPrice = NumberRule.LOTTO_ONE_PRICE.getValue();

        return total / oneLottoPrice;
    }

    public static double getYield(List<Rank> ranks, int size) {
        double yield;
        int sumTotal = 0;

        for (Rank rank : ranks) {
            sumTotal += rank.getTotalReward();
        }

        yield = sumTotal / (double) (size * NumberRule.LOTTO_ONE_PRICE.getValue());
        return (Math.round(yield * 10000) / 100.0);
    }
}
