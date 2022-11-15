package lotto.controller;

import lotto.model.JackpotBonus;
import lotto.model.Lotto;
import lotto.model.Rank;

import java.text.DecimalFormat;
import java.util.*;

public class TotalResult {
    private static final int DEFAULT_RANK_COUNT = 0;
    private static final DecimalFormat yieldFormat = new DecimalFormat("###,###.#");
    private final JackpotBonus jackpotBonus;
    private final List<Lotto> lotteries;
    private final Map<Rank, Integer> rankCounts;

    public TotalResult(JackpotBonus jackpotBonus, List<Lotto> lotteries) {
        this.jackpotBonus = jackpotBonus;
        this.lotteries = lotteries;
        this.rankCounts = setRankCounts(jackpotBonus, lotteries);
    }

    public Map<Rank, Integer> getRankCounts() {
        return rankCounts;
    }

    public String getYield() {
        if (lotteries.size() == 0) {
            return yieldFormat.format(0);
        }

        int sumOfRewards = Arrays.stream(Rank.values())
                .mapToInt(this::rewardPerRank)
                .sum();

        double yield = (double) sumOfRewards / (lotteries.size() * LottoIssuer.MONEY_UNIT) * 100;
        return yieldFormat.format(yield);
    }

    private static Map<Rank, Integer> setRankCounts(JackpotBonus jackpotBonus, List<Lotto> lotteries) {
        Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);

        for (Lotto lotto : lotteries) {
            Rank rankOfLotto = RankCalculator.getRankOf(jackpotBonus, lotto);
            int currentCnt = rankCounts.getOrDefault(rankOfLotto, DEFAULT_RANK_COUNT);
            rankCounts.put(rankOfLotto, currentCnt + 1);
        }
        return rankCounts;
    }

    private int rewardPerRank(Rank rank) {
        int reward = rank.getReward();
        int count = rankCounts.getOrDefault(rank, DEFAULT_RANK_COUNT);

        return reward * count;
    }
}
