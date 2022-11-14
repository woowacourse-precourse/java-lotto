package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningResult {
    private final Map<Ranking, Integer> winningResult = new EnumMap<>(Ranking.class);

    public WinningResult(List<Ranking> rankings) {
        for (Ranking ranking : rankings) {
            winningResult.put(ranking, winningResult.getOrDefault(ranking, 0) + 1);
        }
    }

    public Map<Ranking, Integer> getWinningResult() {
        return winningResult;
    }

    public long calculatePrizeSum() {
        int prizeSum = 0;
        for (Ranking ranking : Ranking.values()) {
            if (ranking == Ranking.DEFAULT) {
                continue;
            }
            prizeSum += ranking.multiple(winningResult.getOrDefault(ranking, 0));
        }
        return prizeSum;
    }
}