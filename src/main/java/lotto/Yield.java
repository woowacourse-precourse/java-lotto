package lotto;

public class Yield {
    private double yield;

    public Yield(LottoResult lottoResult, Money money) {
        double total = lottoResult.getPrizeMoney();
        this.yield = total * 100 / (double) money.getMoney();
    }

    public double ceilYield() {
        return Math.ceil(yield * 10) / 10.0;
    }
}
