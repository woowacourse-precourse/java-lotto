package lotto.domain;

public class Yield {

    private final double yield;

    public Yield(double yield) {
        this.yield = yield;
    }

    public static Yield of(int money, long prize) {
        return new Yield(((double) prize / money) * 100);
    }

    public double getYield() {
        return yield;
    }
}
