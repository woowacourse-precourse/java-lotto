package lotto.model.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.dto.WinningStatisticsDto;

public class WinningStatistics {

    private static final int INIT_NUMBER = 0;
    private static final int LOTTO_PRICE = 1000;
    private static final int PERCENT_UNIT = 100;
    private static final double THIRD_SCORE = 5;
    private static final double SECOND_SCORE = 5.5;

    private final Map<Rank, Integer> rankAndRankCount = new HashMap<>();

    public WinningStatistics(List<Lotto> lottos, Lotto winningLotto, BonusNumber bonusNumber) {
        List<Rank> ranks = collectRanks(lottos, winningLotto, bonusNumber);

        initRankAndRankCount();
        countRanks(ranks);
    }

    private List<Rank> collectRanks(List<Lotto> lottos, Lotto winningLotto, BonusNumber bonusNumber) {
        return lottos.stream()
                .map(lotto -> createRank(lotto, winningLotto, bonusNumber))
                .collect(Collectors.toList());
    }

    private Rank createRank(Lotto lotto, Lotto winningLotto, BonusNumber bonusNumber) {
        double numOfMatch = winningLotto.countMatch(lotto);
        boolean isBonusNumberMatch = bonusNumber.isBonusNumberMatch(lotto);

        if (isSecondScore(numOfMatch, isBonusNumberMatch)) {
            numOfMatch = SECOND_SCORE;
        }
        return RankCreator.create(numOfMatch);
    }

    private boolean isSecondScore(double numOfMatch, boolean isBonusNumberMatch) {
        return numOfMatch == THIRD_SCORE && isBonusNumberMatch;
    }

    private double computeTotalYield() {
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

    public WinningStatisticsDto toDto() {
        double totalYield = computeTotalYield();

        return new WinningStatisticsDto(rankAndRankCount, totalYield);
    }
}
