package lotto.dto;

import lotto.domain.Rank;

import java.util.Map;

public class ResponseRankAggregationDto {

    private final Map<Rank, Integer> rankAggregationMap;

    public ResponseRankAggregationDto(Map<Rank, Integer> rankAggregationMap) {
        this.rankAggregationMap = rankAggregationMap;
    }

    public Map<Rank, Integer> getRankAggregationMap() {
        return rankAggregationMap;
    }

    public static ResponseRankAggregationDto of(Map<Rank, Integer> rankAggregationMap) {
        return new ResponseRankAggregationDto(rankAggregationMap);
    }
}
