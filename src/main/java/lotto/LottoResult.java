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
    public Map<Rank, Integer> getCopyResult() {
        Map<Rank, Integer> copy = new HashMap<>();
        for (Rank rank : result.keySet()) {
            copy.put(rank, result.get(rank));
        }
        return copy;
    }
    public double calculateYield(double money) {
        if (result.size() == 0) {
            return 0;
        }
        double earnMoney = 0;
        for (Rank rank : result.keySet()) {
            earnMoney += rank.money * result.get(rank);
        }
        return Math.round(earnMoney/money * 100 * 10) / 10.0;
    }
}
