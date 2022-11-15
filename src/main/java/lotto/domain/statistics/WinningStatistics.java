package lotto.domain.statistics;

import static lotto.message.PlaceHistoryMessage.makePlaceHistoryMessage;
import static lotto.value.RateValue.PERCENT;

public class WinningStatistics {

    private final PlaceHistory placeHistory;
    private final YieldRate yieldRate;

    public WinningStatistics(PlaceHistory placeHistory, YieldRate yieldRate) {
        this.placeHistory = placeHistory;
        this.yieldRate = yieldRate;
    }

    public static WinningStatistics createWinningStatistics(PlaceHistory placeHistory, YieldRate yieldRate) {
        return new WinningStatistics(placeHistory, yieldRate);
    }

    private String placeHistoryMessage() {
        return makePlaceHistoryMessage(placeHistory).getMessage();
    }

    private String yieldRateMessage() {
        return String.format("총 수익률은 %s입니다.", yieldRate());
    }

    private String yieldRate() {
        return String.format("%,.1f%s", yieldRate.rate(), PERCENT.getRateChar());
    }

    public String getMessage() {
        return String.format("당첨 통계\n---\n%s\n%s", placeHistoryMessage(), yieldRateMessage());
    }
}
