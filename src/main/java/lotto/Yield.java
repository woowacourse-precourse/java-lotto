package lotto;

public class Yield {
    double yield;

    Yield(int myLottoCnt, int totalPrize) {
        double yield = ((double) totalPrize / (myLottoCnt * 1000)) * 100;
        this.yield = Math.round(yield * 10) / 10.0;
    }
}
