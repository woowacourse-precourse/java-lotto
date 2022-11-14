package lotto.domain;

import lotto.util.ResultPrice;

import java.util.Map;

public class MoneyManager {
    private final int money;

    public MoneyManager(int money) {
        this.money = money;
    }

    public Double getMoneyReturn(Map<ResultPrice, Integer> result) {
        long totalPrice = getTotalPrice(result);

        return getRoundPrice(totalPrice);
    }

    private long getTotalPrice(Map<ResultPrice, Integer> result) {
        long totalPrice = 0;

        for (ResultPrice price : result.keySet()) {
            Integer count = result.get(price);
            totalPrice += price.getPrice() * count;
        }

        return totalPrice;
    }

    private Double getRoundPrice(long totalPrice) {
        return Math.round(((double) totalPrice / money * 100) * 10) / (double) 10;
    }
}
