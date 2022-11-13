package lotto.domain;

public class PrizeMoney {

    private final double profit;

    public PrizeMoney(Money ownMoney, int earnMoney) {
        this.profit = (earnMoney / (double) ownMoney.getMoney()) * 100;
    }

    public double getProfit() {
        return this.profit;
    }

}