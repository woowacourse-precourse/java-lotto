package lotto.domain;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;

public class TotalResult {
    private static final String RANK_COUNT_FORMAT = " - %d개";
    private static final int ZERO_COUNT = 0;
    private static final DecimalFormat yieldFormat = new DecimalFormat("###,###.#");
    private final JackpotBonus jackpotBonus;
    private final List<Lotto> lotteries;

    public TotalResult(JackpotBonus jackpotBonus, List<Lotto> lotteries) {
        this.jackpotBonus = jackpotBonus;
        this.lotteries = lotteries;
    }

    public Map<Rank, Integer> getRankCounts() {
        Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);

        for (Lotto lotto : lotteries) {
            Rank rankOfLotto = jackpotBonus.getRankOf(lotto);
            int currentCnt = rankCounts.getOrDefault(rankOfLotto, ZERO_COUNT);
            rankCounts.put(rankOfLotto, currentCnt + 1);
        }
        return rankCounts;
    }

    public List<String> getRankInfoWithCounts(Map<Rank, Integer> rankCounts) {
        List<String> rankInfoWithCounts = new ArrayList<>();

        List<Rank> reversedRanks = getReversedRanks();
        for (Rank rank : reversedRanks) {
            int count = rankCounts.getOrDefault(rank, ZERO_COUNT);
            String line = rank.getInfo() + String.format(RANK_COUNT_FORMAT, count);
            rankInfoWithCounts.add(line);
        }
        return rankInfoWithCounts;
    }

    public String getYield(Map<Rank, Integer> rankCounts) {
        if (lotteries.size() == 0) {
            return yieldFormat.format(0);
        }

        int sumOfRewards = Arrays.stream(Rank.values())
                .mapToInt(rank -> rewardPerRank(rankCounts, rank))
                .sum();
        double yield = (double) sumOfRewards / (lotteries.size() * LottoIssuer.MONEY_UNIT) * 100;

        return yieldFormat.format(yield);
    }

    private static List<Rank> getReversedRanks() {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NO_LUCK)
                .sorted(Comparator.comparing(Rank::getRankNumber).reversed())
                .collect(Collectors.toList());
    }

    private int rewardPerRank(Map<Rank, Integer> rankCounts, Rank rank) {
        int reward = rank.getReward();
        int count = rankCounts.getOrDefault(rank, ZERO_COUNT);

        return reward * count;
    }
}
