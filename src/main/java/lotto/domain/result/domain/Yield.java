package lotto.domain.result.domain;

public class Yield {
    static final int LOTTO_PRICE = 1000;
    public double yield;

    public Yield(int myLottoCnt, int totalPrize) {
        double yield = ((double) totalPrize / (myLottoCnt * LOTTO_PRICE)) * 100;
        this.yield = Math.round(yield * 10.0) / 10.0;
    }
}
