package lotto.domain;

import java.util.HashMap;
import java.util.Map;

import static lotto.domain.LottoRank.*;

public class WinningResult {
    private final Map<LottoRank, Integer> result;

    public WinningResult() {
        this.result = new HashMap<>();
    }

    public void addCorrectCount(ComparedNumber comparedNumber){
        LottoRank rank = getRank(comparedNumber);
        if (rank.isWin()) {
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
    }

    public int getWinningCount(LottoRank lottoRank) {
        return result.get(lottoRank);
    }
}
