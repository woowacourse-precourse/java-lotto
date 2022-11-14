package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningResult {
    private final Map<Ranking, Integer> winningResult = new EnumMap<>(Ranking.class);

    public WinningResult(List<Ranking> rankings) {
        putValues(rankings);
    }

    public long calculatePrizeSum() {
        return winningResult.entrySet().stream()
                .mapToLong(entry -> entry.getKey().multiple(entry.getValue()))
                .sum();
    }

    public Map<Ranking, Integer> getWinningResult() {
        return winningResult;
    }

    private void putValues(List<Ranking> rankings) {
        for (Ranking ranking : rankings) {
            winningResult.put(ranking, winningResult.getOrDefault(ranking, 0) + 1);
        }
    }
}