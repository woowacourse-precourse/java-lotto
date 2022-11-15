package lotto.domain;

import java.util.*;

public class TotalResult {
    private static final int DEFAULT_RANK_COUNT = 0;
    private final JackpotBonus jackpotBonus;
    private final List<Lotto> lotteries;
    private final Map<Rank, Integer> rankCounts;

    public TotalResult(JackpotBonus jackpotBonus, List<Lotto> lotteries) {
        this.jackpotBonus = jackpotBonus;
        this.lotteries = lotteries;
        this.rankCounts = setRankCounts(jackpotBonus, lotteries);
    }

    private static Map<Rank, Integer> setRankCounts(JackpotBonus jackpotBonus, List<Lotto> lotteries) {
        Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);

        for (Lotto lotto : lotteries) {
            Rank rankOfLotto = jackpotBonus.getRankOf(lotto);
            int currentCnt = rankCounts.getOrDefault(rankOfLotto, DEFAULT_RANK_COUNT);
            rankCounts.put(rankOfLotto, currentCnt + 1);
        }
        return rankCounts;
    }

    public Map<Rank, Integer> getRankCounts() {
        return rankCounts;
    }

    public double getYield() {
        if (lotteries.size() == 0) {
            return 0;
        }

        int sumOfRewards = Arrays.stream(Rank.values())
                .mapToInt(this::rewardPerRank)
                .sum();

        return (double) sumOfRewards / (lotteries.size() * LottoIssuer.MONEY_UNIT) * 100;
    }

    private int rewardPerRank(Rank rank) {
        int reward = rank.getReward();
        int count = rankCounts.getOrDefault(rank, DEFAULT_RANK_COUNT);

        return reward * count;
    }
}
