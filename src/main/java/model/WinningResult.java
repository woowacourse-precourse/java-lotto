package model;

import java.util.Map;

public class WinningResult {
    private final Map<Win, Integer> winningResult;

    public WinningResult(Map<Win, Integer> winningResult) {
        this.winningResult = winningResult;
    }

    public Map<Win, Integer> getWinningResult() {
        return winningResult;
    }
}
