package lotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static final int MINIMUM_LOTTO_AMOUNT = 1000;

    private final Map<Ranking, Integer> result = new EnumMap<>(Ranking.class);
    private final List<Ranking> statistics;

    public LottoResult(List<Ranking> statistics) {
        init();
        this.statistics = statistics;
    }

    public Map<Ranking, Integer> matchWinningRank() {
        for (Ranking rank : this.statistics) {
            result.put(rank, result.get(rank) + 1);
        }
        return result;
    }

    private void init() {
        result.put(Ranking.NOTHING, 0);
        result.put(Ranking.FIFTH, 0);
        result.put(Ranking.FOURTH, 0);
        result.put(Ranking.THIRD, 0);
        result.put(Ranking.SECOND, 0);
        result.put(Ranking.FIRST, 0);
    }
}
