package lotto.model;

import java.util.*;

public class RankCounter {private Map<Rank, Integer> rankCounter;

    public RankCounter() {
        rankCounter = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankCounter.put(rank, 0);
        }
    }

    public void addRank(Rank rank) {
        int count = rankCounter.get(rank);
        rankCounter.put(rank, count + 1);
    }

    public int countRank(Rank rank) {
        return rankCounter.get(rank);
    }
}
