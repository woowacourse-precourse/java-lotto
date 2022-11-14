package lotto;

public class Yield {
    double yield;

    Yield(int myLottoCnt, int totalPrize) {
        double yield = totalPrize / (myLottoCnt * 1000);
        this.yield = Math.round(yield * 100) / 100.0;
    }
}
