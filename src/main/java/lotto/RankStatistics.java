package lotto;

import java.util.EnumMap;
import java.util.Map;

public class RankStatistics {
    private final Map<Rank, Integer> rankMap = new EnumMap<>(Rank.class);
    private int totalReward;

    public RankStatistics() {
        for (Rank rank : Rank.values()) {
            rankMap.put(rank, 0);
        }
    }

    public voi
}
