package lotto.domain.rule;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoGroup;
import lotto.domain.lotto.WinningNumber;

import java.util.HashMap;
import java.util.Map;

public class Rule {
    public Map<Rank, Long> getLottoResults(LottoGroup lottoGroup, WinningNumber winningNumber) {
        Map<Rank, Long> rankAndCount = new HashMap<>();
        initializeRankAndCount(rankAndCount);
        countLottoRank(lottoGroup, winningNumber, rankAndCount);

        return rankAndCount;
    }

    private void initializeRankAndCount(Map<Rank, Long> rankAndCount) {
        for (Rank rank : Rank.values()) {
            rankAndCount.put(rank, 0L);
        }
    }

    private void countLottoRank(LottoGroup lottoGroup,
                                WinningNumber winningNumber,
                                Map<Rank, Long> rankAndCount) {
        for (Lotto lotto : lottoGroup.getLottos()) {
            Rank rank = winningNumber.getRank(lotto);
            rankAndCount.put(rank, rankAndCount.get(rank) + 1);
        }
    }
}
