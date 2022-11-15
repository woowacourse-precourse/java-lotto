package lotto.view;

import static lotto.message.PrintMessage.YIELD_RATE_NEXT;
import static lotto.message.PrintMessage.YIELD_RATE_PREVIOUS;
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
        return String.format("%s%s%s", YIELD_RATE_PREVIOUS.getMessage(), yieldRate(), YIELD_RATE_NEXT.getMessage());
    }

    private String yieldRate() {
        return String.format("%,.1f%s", yieldRate.rate(), PERCENT.getRateChar());
    }


}
