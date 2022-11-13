package lotto;

import java.util.Map;

public class WinningStatistic {

    private final Map<Wins, Integer> winningResult;

    public WinningStatistic(Map<Wins, Integer> winningResult) {
        this.winningResult = winningResult;
    }

    public Map<Wins, Integer> getWinningResult() {
        return winningResult;
    }
}
