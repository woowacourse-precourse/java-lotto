package lotto.domain;

import java.util.Map;

public class WinningResult {

    private final Map<Winning, Integer> winningResultMap;

    public WinningResult(Map<Winning, Integer> winningResultMap) {
        this.winningResultMap = winningResultMap;
    }

    public Map<Winning, Integer> getWinningResultMap() {
        return winningResultMap;
    }
}
