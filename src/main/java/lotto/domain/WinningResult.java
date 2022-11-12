package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningResult {

    private WinningNumbers winningNumbers;

    private Map<Ranking, Integer> winningResult = new EnumMap<>(Ranking.class);

    public WinningResult(Lottos lottos) {
        this.winningNumbers = new WinningNumbers();
        initialWinningResult();
        putWinningResult(lottos);
    }

    private void initialWinningResult() {
        for (Ranking ranking : Ranking.values()) {
            winningResult.put(ranking, 0);
        }
    }

    public void putWinningResult(Lottos lottos) {
        List<Ranking> rankings = winningNumbers.calculateRanking(lottos);
        for (Ranking ranking : rankings) {
            winningResult.put(ranking, winningResult.get(ranking) + 1);
        }
    }
}
