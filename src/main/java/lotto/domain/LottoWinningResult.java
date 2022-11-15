package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class LottoWinningResult {
    private Map<LottoRank, Integer> winningResults;

    public LottoWinningResult() {
        winningResults = new EnumMap<>(LottoRank.class);
        for (LottoRank rank : LottoRank.values()) {
            winningResults.put(rank, 0);
        }
    }

    public int getWinningResult(LottoRank rank) {
        return winningResults.get(rank);
    }

    public void updateWinningResult(LottoRank rank) {
        winningResults.put(rank, winningResults.get(rank) + 1);
    }
}
