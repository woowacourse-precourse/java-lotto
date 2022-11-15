package lotto.domain.statistics;

import java.text.DecimalFormat;

public class Yield {

    DecimalFormat df = new DecimalFormat("###,###.0");

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

    @Override
    public String toString() {
        return df.format(yield);
    }
}
