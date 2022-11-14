package domain;

import java.util.HashMap;
import java.util.Map;

public class RankInfo {
    private final Map<Rank, Integer> rankInfo;

    public RankInfo() {
        rankInfo = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankInfo.put(rank, 0);
        }
    }

    public void countUp(Rank rank) {
        rankInfo.put(rank, rankInfo.get(rank) + 1);
    }

    public int getMatchNumber(Rank rank) {
        return rankInfo.get(rank);
    }
}
