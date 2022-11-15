package domain;

import java.util.EnumMap;
import java.util.Map;

public class Result {
    private Map<LottoRank, Integer> statistics;

    public Result() {
        statistics = new EnumMap<>(LottoRank.class);
        for (LottoRank rating : LottoRank.values()) {
            statistics.put(rating, 0);
        }
    }

    public void increment(LottoRank rank) {
        Integer value=statistics.get(rank);
        statistics.put(rank, ++value);
    }

}
