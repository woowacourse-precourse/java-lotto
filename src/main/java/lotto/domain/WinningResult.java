package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class WinningResult {

    private WinningNumbers winningNumbers;

    private Map<Ranking, Integer> winningResult = new EnumMap<>(Ranking.class);

    public WinningResult() {
        this.winningNumbers = new WinningNumbers();
        initialWinningResult();
    }

    private void initialWinningResult() {
        for (Ranking ranking : Ranking.values()) {
            winningResult.put(ranking, 0);
        }
    }
}
