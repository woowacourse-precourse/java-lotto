package lotto.domain;

import lotto.data.LottoRank;

import java.util.List;
import java.util.Map;

public class LottoComparator {

    private void updateWinningAmount(Map<LottoRank, Integer> winningCounts, int winningCount, boolean isSameWithBonus) {
        LottoRank lottoRank = LottoRank.getLottoRankByWinningCountAndBonus(winningCount, isSameWithBonus);
        int winningAmount = winningCounts.get(lottoRank);
        winningCounts.put(lottoRank, winningAmount + 1);
    }

    private void calculateWinningAmount(Lotto lotto, List<Integer> winningNumbers, int bonus, Map<LottoRank, Integer> winningCounts) {
        int winningCount = lotto.calculateWinningCount(winningNumbers);
        boolean isSameWithBonus = lotto.isSameWithBonus(bonus);

        if (winningCount < 3)
            return;

        updateWinningAmount(winningCounts, winningCount, isSameWithBonus);
    }
}