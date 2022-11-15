package lotto.domain.result.domain;

import static lotto.constant.Integer.LOTTO_PRICE;

public class Yield {
    public double yield;

    public Yield(int myLottoCnt, int totalPrize) {
        double yield = ((double) totalPrize / (myLottoCnt * LOTTO_PRICE)) * 100;
        this.yield = Math.round(yield * 10.0) / 10.0;
    }
}
