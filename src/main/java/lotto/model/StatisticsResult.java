package lotto.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StatisticsResult {

    private Map<WinningScore, Integer> winningScoreResult;

    public StatisticsResult() {
        this.winningScoreResult = new HashMap<>() {{
            put(WinningScore.THREE, 0);
            put(WinningScore.FOUR, 0);
            put(WinningScore.FIVE, 0);
            put(WinningScore.BONUS, 0);
            put(WinningScore.SIX, 0);
        }};
    }

    public Map<WinningScore, Integer> getWinningScoreResult() {
        return winningScoreResult;
    }

    public Set<WinningScore> getAllScore() {
        return winningScoreResult.keySet();
    }

    public void addScoreCount(WinningScore winningScore, int count) {
        winningScoreResult.put(winningScore, count);
    }

    public int getCount(WinningScore winningScore) {
        return winningScoreResult.getOrDefault(winningScore, 0);
    }

}
