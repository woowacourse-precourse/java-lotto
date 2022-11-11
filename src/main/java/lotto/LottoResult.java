package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private Map<Rank, Integer> result;

    LottoResult () {
        result = new HashMap<>();
    }

    public void insertResult(Rank rank) {
        result.put(rank, result.getOrDefault(rank, 0)+1);
    }
    public Map getCopyResult() {
        Map<Rank, Integer> copy = new HashMap<>();
        for (Rank rank : result.keySet()) {
            copy.put(rank, result.get(rank));
        }
        return copy;
    }
}
