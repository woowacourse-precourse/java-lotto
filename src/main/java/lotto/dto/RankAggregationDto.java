package lotto.dto;

import lotto.domain.Rank;

import java.util.Map;

public class RankAggregationDto {

    private final Map<Rank, Integer> rankAggregationMap;

    public RankAggregationDto(Map<Rank, Integer> rankAggregationMap) {
        this.rankAggregationMap = rankAggregationMap;
    }

    public static RankAggregationDto of(Map<Rank, Integer> rankAggregationMap) {
        return new RankAggregationDto(rankAggregationMap);
    }

    public Map<Rank, Integer> getRankAggregationMap() {
        return rankAggregationMap;
    }
}
