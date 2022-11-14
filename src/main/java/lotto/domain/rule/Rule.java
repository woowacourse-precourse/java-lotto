package lotto.domain.rule;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoGroup;
import lotto.domain.lotto.WinningNumber;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Rule {
    public Map<Rank, Integer> getLottoResults(LottoGroup lottoGroup, WinningNumber winningNumber) {
        Map<Rank, Integer> rankAndCount = new TreeMap<>(Comparator.reverseOrder());
        initializeRankAndCount(rankAndCount);
        countLottoRank(lottoGroup, winningNumber, rankAndCount);

        return rankAndCount;
    }

    private void initializeRankAndCount(Map<Rank, Integer> rankAndCount) {
        for (Rank rank : Rank.values()) {
            rankAndCount.put(rank, 0);
        }
    }

    private void countLottoRank(LottoGroup lottoGroup,
                                WinningNumber winningNumber,
                                Map<Rank, Integer> rankAndCount) {
        for (Lotto lotto : lottoGroup.getLottos()) {
            Rank rank = winningNumber.getRank(lotto);
            rankAndCount.put(rank, rankAndCount.get(rank) + 1);
        }
    }
}
