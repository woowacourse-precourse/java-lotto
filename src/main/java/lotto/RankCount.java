package lotto;

import java.util.EnumMap;
import java.util.Map;

public class RankCount {
    private Map<Rank, Integer> rankCounter;

    public RankCount() {
        rankCounter = new EnumMap<Rank, Integer>(Rank.class);
        for (Rank rank : Rank.values()) {
            rankCounter.put(rank, 0);
        }
    }

    public void rankCounting(Rank rank) {
        rankCounter.put(rank, rankCounter.get(rank) + 1);
    }

    public int getCount(Rank rank) {
        return rankCounter.get(rank);
    }
}
