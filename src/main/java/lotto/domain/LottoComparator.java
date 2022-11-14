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
}