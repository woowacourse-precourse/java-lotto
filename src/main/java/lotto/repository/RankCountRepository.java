package lotto.repository;

import java.util.HashMap;
import lotto.domain.Rank;

public class RankCountRepository {

    private final HashMap<Rank, Integer> rankCountMap = new HashMap<>();

    public void save(Rank rank) {
        rankCountMap.put(rank, rankCountMap.getOrDefault(rank, 1));
    }

    public Integer findOne(Rank rank) {
        return rankCountMap.getOrDefault(rank, 0);
    }
}
