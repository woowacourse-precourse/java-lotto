package lotto.winning;

import java.util.HashMap;
import java.util.Map;
import lotto.LottoGame.LottoGame;

public class WinningStatistical {
    public static final int PERCENT = 100;
    public static final int DEFAULT_WINNING_COUNT = 0;
    private final Map<WinningResult, Integer> winningResultCount = new HashMap<>();
    private Integer boughtPrice = 0;
    private Long winningPrice = 0L;

    public void addWinningResult(WinningResult winningResult) {
        Integer prevWinningResultCount = winningResultCount.getOrDefault(winningResult, DEFAULT_WINNING_COUNT);
        winningResultCount.put(winningResult, prevWinningResultCount + 1);
        winningPrice += winningResult.getPrize();
        boughtPrice += LottoGame.PRICE_UNIT;
    }

    public Integer getCountOfWinningResult(WinningResult winningResult) {
        return winningResultCount.getOrDefault(winningResult, DEFAULT_WINNING_COUNT);
    }

    public Double calculateProfit() {
        return (winningPrice.doubleValue() / boughtPrice) * PERCENT;
    }
}
