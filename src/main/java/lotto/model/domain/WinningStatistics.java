package lotto.model.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {

    private static final int STATISTICS_INIT_NUM = 0;
    private static final int LOTTO_PRICE = 1000;
    private static final int PERCENT_UNIT = 100;

    private final Map<Rank, Integer> rankAndRankCount = new HashMap<>();

    public WinningStatistics(List<Lotto> lottos, WinningNumber winningNumber) {
        List<Rank> ranks = winningNumber.collectRanks(lottos);

        initRankAndRankCount();
        countRanks(ranks);
    }

    public double computeTotalYield() {
        return (sumOfReward() / sumOfLottoPrice()) * PERCENT_UNIT;
    }

    private int sumOfLottoPrice() {
        int sumOfLottoCount = rankAndRankCount.keySet()
                .stream()
                .map(rankAndRankCount::get)
                .reduce(Integer::sum)
                .orElse(STATISTICS_INIT_NUM);

        return sumOfLottoCount * LOTTO_PRICE;
    }

    private double sumOfReward() {
        return (float) rankAndRankCount.keySet()
                .stream()
                .map(this::sumOfOneRankReward)
                .reduce(Integer::sum)
                .orElse(STATISTICS_INIT_NUM);
    }

    private int sumOfOneRankReward(Rank rank) {
        return rank.getReward() * rankAndRankCount.get(rank);
    }

    private void initRankAndRankCount() {
        rankAndRankCount.put(Rank.NOTHING, STATISTICS_INIT_NUM);
        rankAndRankCount.put(Rank.FIFTH, STATISTICS_INIT_NUM);
        rankAndRankCount.put(Rank.FOURTH, STATISTICS_INIT_NUM);
        rankAndRankCount.put(Rank.THIRD, STATISTICS_INIT_NUM);
        rankAndRankCount.put(Rank.SECOND, STATISTICS_INIT_NUM);
        rankAndRankCount.put(Rank.FIRST, STATISTICS_INIT_NUM);
    }

    private void countRanks(List<Rank> ranks) {
        ranks.stream()
                .forEach(this::countRank);
    }

    private void countRank(Rank rank) {
        int rankCount = rankAndRankCount.get(rank);

        rankAndRankCount.put(rank, ++rankCount);
    }

    public Map<Rank, Integer> get() {
        return rankAndRankCount;
    }
}
