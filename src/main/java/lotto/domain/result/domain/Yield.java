package lotto.domain.result.domain;

public class Yield {
    public double yield;

    public Yield(int myLottoCnt, int totalPrize) {
        double yield = ((double) totalPrize / (myLottoCnt * 1000)) * 100;
        this.yield = Math.round(yield * 10) / 10.0;
    }
}
