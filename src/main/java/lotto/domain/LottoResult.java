package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final Map<String, Integer> result;

    public LottoResult() {
        result = new HashMap<>();
    }

    public void add(Ranking ranking) {
        if (!result.containsKey(ranking.name())) {
            result.put(ranking.name(), 1);
            return;
        }
        int count = result.get(ranking.name());
        result.put(ranking.name(), count + 1);
    }

    public long calculateProfits() {
        long profits = 0;
        for (String grade : result.keySet()) {
            int count = result.get(grade);
            profits += ((long) Ranking.valueOf(grade).getPrize() * count);
        }
        return profits;
    }

    public int get(String rankName) {
        Integer count = result.get(rankName);

        if (count == null) {
            return 0;
        }
        return count;
    }
}
