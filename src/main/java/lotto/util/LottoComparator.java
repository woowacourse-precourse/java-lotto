package lotto.util;

import lotto.config.InputConfig;
import lotto.domain.Lotto;
import lotto.domain.Rank;

import java.util.*;

public class LottoComparator {

    public static Map<Rank, Integer> compareToPrize(List<Lotto> lottoList, Lotto prizeLotto, int bonusNumber) {
        Map<Rank, Integer> ranked = new LinkedHashMap<>();
        for (Lotto lotto : lottoList) {
            Rank result = getLottoRank(lotto, prizeLotto, bonusNumber);
            ranked.put(result, ranked.getOrDefault(result, 0) + 1);
        }
        return ranked;
    }

    private static Rank getLottoRank(Lotto ownLotto, Lotto prizeLotto, int bonusNumber) {
        int cnt = countNumberCorrectness(ownLotto, prizeLotto);
        boolean bonus = hasBonusNumber(ownLotto, bonusNumber);
        int maxValue = InputConfig.LOTTO_NUMBER_COUNT;

        if (cnt == maxValue) {
            return Rank.FIRST;
        }
        if (cnt == maxValue - 1 && bonus) {
            return Rank.SECOND;
        }
        if (cnt == maxValue - 1) {
            return Rank.THIRD;
        }
        if (cnt == maxValue - 2) {
            return Rank.FOURTH;
        }
        if (cnt == maxValue - 3) {
            return Rank.FIFTH;
        }
        return Rank.NONE;
    }

    private static boolean hasBonusNumber(Lotto ownLotto, int bonusNumber) {
        return ownLotto.contains(bonusNumber);
    }

    private static int countNumberCorrectness(Lotto lotto, Lotto prizeLotto) {
        Set<Integer> ownLotto = lotto.toSet();
        Set<Integer> matchedLotto = prizeLotto.toSet();

        matchedLotto.removeAll(ownLotto);
        return ownLotto.size() - matchedLotto.size();
    }

    public Rank forTest_getLottoRank(Lotto ownLotto, Lotto prizeLotto, int bonusNumber) {
        return getLottoRank(ownLotto, prizeLotto, bonusNumber);
    }
}
