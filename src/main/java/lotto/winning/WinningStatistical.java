package lotto.winning;

import java.util.HashMap;
import java.util.Map;

public class WinningStatistical {
    private final Map<WinningResult, Integer> winningResultCount = new HashMap<>();
    private Integer boughtPrice = 0;
    private Long winningPrice = 0L;

    public void addWinningResult(WinningResult winningResult) {
        Integer prevWinningResultCount = winningResultCount.getOrDefault(winningResult, 0);
        winningResultCount.put(winningResult, prevWinningResultCount + 1);
        winningPrice += winningResult.getPrize();
        boughtPrice += 1000;
    }

    public Integer getCountOfWinningResult(WinningResult winningResult) {
        return winningResultCount.getOrDefault(winningResult, 0);
    }

    public Double calculateProfit() {
        return (winningPrice.doubleValue() / boughtPrice) * 100;
    }
}
