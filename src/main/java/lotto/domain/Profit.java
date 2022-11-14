package lotto.domain;

public class Profit {
    private final double profit;

    public Profit(Money buyMoney, int earnMoney) {
        this.profit = (earnMoney / (double) buyMoney.getMoney()) * 100;
    }

    public double getProfit() {
        return this.profit;
    }
}
