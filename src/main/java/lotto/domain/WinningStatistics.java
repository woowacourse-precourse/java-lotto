package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {
    private Map<Ranking, Integer> winningStatisticsMap;

    public WinningStatistics(List<Ranking> rankingList) {
        this.winningStatisticsMap= new EnumMap<>(Ranking.class);
        for (Ranking ranking : Ranking.values()) {
            winningStatisticsMap.put(ranking, 0);
        }
        for (Ranking ranking : rankingList) {
            winningStatisticsMap.put(ranking, winningStatisticsMap.get(ranking) + 1);
        }
    }

    public Map<Ranking, Integer> getWinningStatisticsMap() {
        return winningStatisticsMap;
    }

}
