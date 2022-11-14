package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningStatistics {

    private static final int INIT_NUMBER = 0;
    private static final int LOTTO_PRICE = 1000;
    private static final int PERCENT_UNIT = 100;

    private final Map<Rank, Integer> rankAndRankCount = new HashMap<>();

    public WinningStatistics(List<Lotto> lottos, WinningNumber winningNumber) {
        List<Rank> ranks = winningNumber.collectRanks(lottos);

        initRankAndRankCount();
        countRanks(ranks);
    }

    public double computeTotalYield() {
        double rewardSum = sumOfReward();
        int lottoPriceSum = sumOfLottoPrice();

        return (rewardSum / lottoPriceSum) * PERCENT_UNIT;
    }

    private int sumOfLottoPrice() {
        int sumOfLottoCount = rankAndRankCount.keySet()
                .stream()
                .map(rankAndRankCount::get)
                .reduce(Integer::sum)
                .orElse(INIT_NUMBER);

        return sumOfLottoCount * LOTTO_PRICE;
    }

    private double sumOfReward() {
        return (double) rankAndRankCount.keySet()
                .stream()
                .map(this::sumOfOneRankReward)
                .reduce(Integer::sum)
                .orElse(INIT_NUMBER);
    }

    private int sumOfOneRankReward(Rank rank) {
        return rank.getReward() * rankAndRankCount.get(rank);
    }

    private void initRankAndRankCount() {
        rankAndRankCount.put(Rank.NOTHING, INIT_NUMBER);
        rankAndRankCount.put(Rank.FIFTH, INIT_NUMBER);
        rankAndRankCount.put(Rank.FOURTH, INIT_NUMBER);
        rankAndRankCount.put(Rank.THIRD, INIT_NUMBER);
        rankAndRankCount.put(Rank.SECOND, INIT_NUMBER);
        rankAndRankCount.put(Rank.FIRST, INIT_NUMBER);
    }

    private void countRanks(List<Rank> ranks) {
        ranks.forEach(this::countRank);
    }

    private void countRank(Rank rank) {
        int rankCount = rankAndRankCount.get(rank);

        rankAndRankCount.put(rank, ++rankCount);
    }

    public Map<Rank, Integer> get() {
        return rankAndRankCount;
    }
}
