package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final Map<Rank, Integer> result = new HashMap<>();

    public LottoResult() {
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    public void putRank(Rank rank) {
        result.put(rank, result.get(rank) + 1);
    }

    public Long getReward() {
        return result.entrySet().stream().mapToLong(e -> e.getKey().prize(e.getValue())).sum();
    }
}
