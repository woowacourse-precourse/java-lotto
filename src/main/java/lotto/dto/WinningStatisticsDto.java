package lotto.dto;

import java.util.Map;
import lotto.domain.Rank;

public class WinningStatisticsDto {

    private final Map<Rank, Integer> rankAndRankCount;
    private final double totalYield;

    public WinningStatisticsDto(Map<Rank, Integer> rankAndRankCount, double totalYield) {
        this.rankAndRankCount = rankAndRankCount;
        this.totalYield = totalYield;
    }

    public Map<Rank, Integer> getRankAndRankCount() {
        return rankAndRankCount;
    }

    public double getTotalYield() {
        return totalYield;
    }
}
