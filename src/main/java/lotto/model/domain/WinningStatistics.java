package lotto.model.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {

    private static final int STATISTICS_INIT_NUM = 0;

    private final Map<Rank, Integer> rankAndRankCount = new HashMap<>();

    public WinningStatistics(List<Lotto> lottoCollection, WinningNumber winningNumber) {
        List<Rank> rankCollection = winningNumber.collectRanks(lottoCollection);

        initRankAndRankCount();
        countRanks(rankCollection);
    }

    private void initRankAndRankCount() {
        rankAndRankCount.put(Rank.FIFTH, STATISTICS_INIT_NUM);
        rankAndRankCount.put(Rank.FOURTH, STATISTICS_INIT_NUM);
        rankAndRankCount.put(Rank.THIRD, STATISTICS_INIT_NUM);
        rankAndRankCount.put(Rank.SECOND, STATISTICS_INIT_NUM);
        rankAndRankCount.put(Rank.FIRST, STATISTICS_INIT_NUM);
    }

    private void countRanks(List<Rank> rankCollection) {
        rankCollection.stream()
                .forEach(this::countRank);
    }

    private void countRank(Rank rank) {
        int rankCount = rankAndRankCount.get(rank);

        rankAndRankCount.put(rank, ++rankCount);
    }


}
