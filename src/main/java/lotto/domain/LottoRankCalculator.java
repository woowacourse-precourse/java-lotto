package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoRankCalculator {
    private LottoRankCalculator(){};

    public static Map<Lotto, LottoRank> calculateRanks(WinningNumbers winningNumbers, Lottos lottos) {
        Map<Lotto, LottoRank> ranks = new HashMap<>();
        for (Lotto lotto : lottos) {
            LottoRank rank = calculateRank(winningNumbers, lotto);
            ranks.put(lotto, rank);
        }
        return ranks;
    }

    private static LottoRank calculateRank(WinningNumbers winningNumbers, Lotto lotto) {
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

    private static int getMatchedNumberCount(WinningNumbers winningNumbers, Lotto lotto) {
        int matched = 0;
        for (int index = 0; index < LottoRule.TOTAL_COUNT; index++) {
            Integer number = lotto.get(index);
            if (winningNumbers.mainDrawContains(number)) {
                matched += 1;
            }
        }
        return matched;
    }

    private static boolean isBonusMatch(WinningNumbers winningNumbers, Lotto lotto) {
        for (int index = 0; index < LottoRule.TOTAL_COUNT; index++) {
            Integer number = lotto.get(index);
            if (winningNumbers.isEqualToBonusNumbers(number)) {
                return true;
            }
        }
        return false;
    }
}
