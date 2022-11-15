package lotto;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {
    private final Map<Ranking, Integer> winningResult = new EnumMap<Ranking, Integer>(Ranking.class);

    public WinningResult(List<Ranking> rankings) {
        injectValues(rankings);
    }
    public long getAllPrize() {
        return winningResult.entrySet()
                .stream()
                .mapToLong(entry -> entry.getKey().mul(entry.getValue())).sum();
    }
    public Map<Ranking,Integer> getWinningResult() {
        return winningResult;
    }

    private void injectValues(List<Ranking> rankings) {
        for (Ranking ranking : rankings) {
            winningResult.put(ranking, winningResult.getOrDefault(ranking, 0) + 1);
        }
    }
}
