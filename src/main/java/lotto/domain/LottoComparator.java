package lotto.domain;

import lotto.data.LottoRank;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.data.LottoInfo.MINIMUM_RANK;

public class LottoComparator {

    private void updateWinningAmount(Map<LottoRank, Integer> winningCounts, int winningCount, boolean isSameWithBonus) {
        LottoRank lottoRank = LottoRank.getLottoRankByWinningCountAndBonus(winningCount, isSameWithBonus);
        int winningAmount = winningCounts.get(lottoRank);
        winningCounts.put(lottoRank, winningAmount + 1);
    }

    private void calculateWinningAmount(Lotto lotto, List<Integer> winningNumbers, int bonus, Map<LottoRank, Integer> winningCounts) {
        int winningCount = lotto.calculateWinningCount(winningNumbers);
        boolean isSameWithBonus = lotto.isSameWithBonus(bonus);

        if (winningCount < MINIMUM_RANK.getValue())
            return;

        updateWinningAmount(winningCounts, winningCount, isSameWithBonus);
    }

    public Map<LottoRank, Integer> createWinningCounts(List<Lotto> lottos, List<Integer> winningNumbers, int bonus) {
        Map<LottoRank, Integer> winningCounts = new HashMap<>();
        initWinningCounts(winningCounts);

        for (Lotto lotto : lottos) {
            calculateWinningAmount(lotto, winningNumbers, bonus, winningCounts);
        }

        return winningCounts;
    }

    private void initWinningCounts(Map<LottoRank, Integer> winningCounts) {
        for (LottoRank lottoRank : LottoRank.getLottoRanks()) {
            winningCounts.put(lottoRank, 0);
        }
    }
}