package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoRankCalculator {
    private static LottoRankCalculator lottoCalculator;

    private LottoRankCalculator() {

    }

    public static LottoRankCalculator getInstance() {
        if (lottoCalculator == null) {
            lottoCalculator = new LottoRankCalculator();
        }
        return lottoCalculator;
    }

    public Map<LottoRank, Integer> calculateRanks(WinningNumbers winningNumbers, Lottos lottos) {
        Map<LottoRank, Integer> ranks = new HashMap<>();
        for (Lotto lotto : lottos) {
            LottoRank rank = calculateRank(winningNumbers, lotto);
            ranks.put(rank, ranks.getOrDefault(rank, 0) + 1);
        }
        return ranks;
    }

    public LottoRank calculateRank(WinningNumbers winningNumbers, Lotto lotto) {
        int match = getMatchedNumberCount(winningNumbers, lotto);
        boolean isBonusMatch = isBonusMatch(winningNumbers, lotto);

        LottoRank lottoRank = null;
        for (LottoRank rank : LottoRank.values()) {
            if (rank.getMatch() == match && (!rank.shouldBonusMatch() || isBonusMatch)) {
                lottoRank = rank;
                break;
            }
        }
        return lottoRank;
    }

    private int getMatchedNumberCount(WinningNumbers winningNumbers, Lotto lotto) {
        int matched = 0;
        for (int index = 0; index < LottoRule.TOTAL_COUNT; index++) {
            Integer number = lotto.get(index);
            if (winningNumbers.contains(number)) {
                matched += 1;
            }
        }
        return matched;
    }

    private boolean isBonusMatch(WinningNumbers winningNumbers, Lotto lotto) {
        for (int index = 0; index < LottoRule.TOTAL_COUNT; index++) {
            Integer number = lotto.get(index);
            if (winningNumbers.isEqualToBonusNumbers(number)) {
                return true;
            }
        }
        return false;
    }
}
