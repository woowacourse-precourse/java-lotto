package lotto;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Results {

    public static final int INCREASED_VALUE = 1;
    public static final int DEFAULT = 0;

    private final Map<Ranking, Integer> lottoRankingCount;

    public Results() {
        this.lottoRankingCount = new HashMap<>();
    }

    public void addDefaultValue() {
        for (Ranking ranking : Ranking.values()) {
            this.lottoRankingCount.put(ranking, DEFAULT);
        }
    }

    public void addPrizeCount(Ranking ranking) {
        this.lottoRankingCount.computeIfPresent(ranking, (key, value) -> value + INCREASED_VALUE);
    }

    public Map<Ranking, Integer> getLottoRankingCount() {
        return Collections.unmodifiableMap(lottoRankingCount);
    }

}
