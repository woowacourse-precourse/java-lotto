package lotto.service;

import lotto.domain.Winner;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoComparator {

    private final List<Integer> prizeLotto;
    private final int prizeBonusNumber;

    public LottoComparator(List<Integer> prizeLotto, int prizeBonusNumber) {
        this.prizeLotto = prizeLotto;
        this.prizeBonusNumber = prizeBonusNumber;
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

    private boolean hasBonusNumber(List<Integer> ownLotto) {
        return ownLotto.contains(prizeBonusNumber);
    }

    private int countNumberCorrectness(List<Integer> ownLotto) {
        Set<Integer> ownLottoSet = new HashSet<>(ownLotto);
        Set<Integer> prizeLottoSet = new HashSet<>(prizeLotto);

        prizeLottoSet.removeAll(ownLottoSet);
        return prizeLotto.size() - prizeLottoSet.size();
    }
}
