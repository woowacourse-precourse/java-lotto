package lotto.service;

import lotto.config.InputConfig;
import lotto.domain.Lotto;
import lotto.domain.Winner;

import java.util.*;

public class LottoComparator {

    public Map<Winner, Integer> compareToPrize(List<Lotto> lottoList, Lotto prizeLotto, int bonusNumber) {
        Map<Winner, Integer> ranked = new LinkedHashMap<>();
        for (Lotto lotto : lottoList) {
            Winner result = getLottoRank(lotto, prizeLotto, bonusNumber);
            ranked.put(result, ranked.getOrDefault(result, 0) + 1);
        }
        return ranked;
    }

    public Winner getLottoRank(List<Integer> ownLotto) {
        int cnt = countNumberCorrectness(ownLotto);
        boolean bonus = hasBonusNumber(ownLotto);
        int maxValue = prizeLotto.size();

        if (cnt == maxValue) {
            return Winner.FIRST;
        }
        if (cnt == maxValue - 1 && bonus) {
            return Winner.SECOND;
        }
        if (cnt == maxValue - 1) {
            return Winner.THIRD;
        }
        if (cnt == maxValue - 2) {
            return Winner.FOURTH;
        }
        if (cnt == maxValue - 3) {
            return Winner.FIFTH;
        }
        return Winner.NONE;
    }

    private boolean hasBonusNumber(Lotto ownLotto, int bonusNumber) {
        return ownLotto.contains(bonusNumber);
    }

    private int countNumberCorrectness(Lotto lotto, Lotto prizeLotto) {
        Set<Integer> ownLotto = lotto.toSet();
        Set<Integer> matchedLotto = prizeLotto.toSet();

        matchedLotto.removeAll(ownLotto);
        return ownLotto.size() - matchedLotto.size();
    }

        prizeLottoSet.removeAll(ownLottoSet);
        return prizeLotto.size() - prizeLottoSet.size();
    }
}
