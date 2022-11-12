package lotto.domain;

import java.util.EnumMap;

public class ResultRepository {

    EnumMap<Rank, Integer> result;

    public ResultRepository() {
        result = new EnumMap<>(Rank.class);
    }

    public void add(Rank rank) {
        result.put(rank, result.getOrDefault(rank, 0) + 1);
    }

    public Integer getResultAboutRank(Rank rank) {
        return result.get(rank);
    }



}
