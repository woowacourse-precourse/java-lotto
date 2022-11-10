package lotto;

import java.util.HashMap;
import java.util.Map;

public class RankCount {
    private final HashMap<Integer, Integer> rankCounter;

    public RankCount() {
        rankCounter = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankCounter.put(rank.getNumberCount(), 0);
        }
    }

    public void rankCounting(int rankCount) {
        rankCounter.put(rankCount, rankCounter.get(rankCount) + 1);
    }

    public Map<Integer, Integer> getCount() {
        return rankCounter;
    }
}
