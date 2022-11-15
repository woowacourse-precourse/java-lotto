package lotto.domain;

public class Profit {
    private final double profit;

    public Profit(Money money, double totalPrize) {
        this.profit = Math.round(totalPrize*100*10/ (double) money.getMoney())/10.0;
    }

    public double getProfit() {
        return this.profit;
    }
}
