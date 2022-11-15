package lotto.service;

import static lotto.util.PrintService.printWinningStatistic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;
import lotto.repository.RankCountRepository;

public class WinningStatisticService {

    private final RankCountRepository rankCountRepository;

    public WinningStatisticService(RankCountRepository rankCountRepository) {
        this.rankCountRepository = rankCountRepository;
    }

    public void showWinningStatistic(int purchasedPrice) {
        Map<Rank, Integer> rankCountMap = getRankCountMap();
        double yield = getYield(getTotalAmount(rankCountMap), purchasedPrice);
        printWinningStatistic(rankCountMap, yield);
    }

    private Map<Rank, Integer> getRankCountMap() {
        Map<Rank, Integer> rankCountMap = new HashMap<>();
        List.of(Rank.values()).forEach(rank -> rankCountMap.put(rank, getRankCount(rank)));
        return rankCountMap;
    }

    public Integer getRankCount(Rank rank) {
        return rankCountRepository.findOne(rank);
    }

    private long getTotalAmount(Map<Rank, Integer> rankCountMap) {
        return rankCountMap.entrySet().stream()
            .mapToLong(entry -> (long) entry.getKey().getWinningAmount() * entry.getValue()).sum();
    }

    private double getYield(long totalAmount, int purchasedPrice) {
        return ((double) totalAmount / purchasedPrice) * 100;
    }

    public void saveRankCount(List<Lotto> lottos, WinningLotto winningLotto) {
        lottos.forEach(lotto -> {
            int matchedNumber = getMatchedNumber(lotto, winningLotto.getLotto().getNumbers());
            boolean hasBonusNumber = hasBonusNumber(lotto, winningLotto.getBonusNumber());
            Rank.of(matchedNumber, hasBonusNumber).ifPresent(rankCountRepository::save);
        });
    }

    private Integer getMatchedNumber(Lotto lotto, List<Integer> winningLottoNumbers) {
        List<Integer> lottoNumbers = new ArrayList<>(lotto.getNumbers());
        lottoNumbers.retainAll(winningLottoNumbers);
        return lottoNumbers.size();
    }

    private boolean hasBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
