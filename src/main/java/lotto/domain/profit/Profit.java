package lotto.domain.profit;

import lotto.domain.money.Money;

public class Profit {

    private final Double rate;

    public Profit(Money budget, Money reward) {
        this.rate = (reward.getMoney() / (double) budget.getMoney()) * 100;
    }

    public static Profit create(Money budget, Money reward) {
        return new Profit(budget, reward);
    }

    public Double getRate() {
        return rate;
    }
}
