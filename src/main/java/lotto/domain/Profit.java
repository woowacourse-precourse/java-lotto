package lotto.domain;

public class Profit {
    private final double profit;

    public Profit(Money money, double totalPrize) {
        this.profit = totalPrize / (double) money.getMoney();
    }

    public double getProfit() {
        return this.profit;
    }
}
