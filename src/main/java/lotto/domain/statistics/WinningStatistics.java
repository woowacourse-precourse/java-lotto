package lotto.domain.statistics;

import static lotto.message.PlaceHistoryMessage.makePlaceHistoryMessage;
import static lotto.message.YieldRateMessage.makeYieldRateMessage;

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
        return makeYieldRateMessage(yieldRate).getMessage();
    }

    public String getMessage() {
        return String.format("당첨 통계\n---\n%s\n%s", placeHistoryMessage(), yieldRateMessage());
    }
}
