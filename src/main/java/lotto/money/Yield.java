package lotto.money;

public class Yield {

    private final double yield;

    public Yield(Money purchaseMoney, Money earning) {
        this.yield = earning.getMoney() / (double) purchaseMoney.getMoney() * 100;
    }

    @Override
    public String toString() {
        return (String.format("%.1f%%", yield));
    }
}
