package lotto.view;

import static lotto.value.RateValue.PERCENT;

import lotto.domain.statistics.YieldRate;

public class YieldRateMessage {
    private final YieldRate yieldRate;

    public YieldRateMessage(YieldRate yieldRate) {
        this.yieldRate = yieldRate;
    }

    public static YieldRateMessage makeYieldRateMessage(YieldRate yieldRate) {
        return new YieldRateMessage(yieldRate);
    }

    public String getMessage() {
        return String.format("총 수익률은 %s입니다.", yieldRate());
    }

    private String yieldRate() {
        return String.format("%,.1f%s", yieldRate.rate(), PERCENT.getRateChar());
    }


}
