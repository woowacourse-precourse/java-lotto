package lotto.model;

import java.util.List;

public class WinningRecord {
    private List<Integer> winningHistory;
    private int investment;

    public List<Integer> getWinningHistory() {
        return winningHistory;
    }

    public void setWinningHistory(List<Integer> winningHistory) {
        this.winningHistory = winningHistory;
        this.investment = winningHistory.stream().reduce(0, Integer::sum) * 1000;
    }

    public double getYield() {
        return 0.0;
    }

}
