package lotto.model;

import java.util.List;

public class WinningRecord {
    private List<Integer> winningHistory;
    private long investment;

    public WinningRecord(List<Integer> winningHistory) {
        this.winningHistory = winningHistory;
        this.investment = winningHistory.stream().reduce(0, Integer::sum) * 1000;
    }

    public List<Integer> getWinningHistory() {
        return winningHistory;
    }

    public double getYield() {
        return 0.0;
    }
}
