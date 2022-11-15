package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.ui.Ouput;

public class LottoChecker {

    public int compare(Lotto purchasedLotto, Lotto winningLotto) {
        int count = 0;
        for (int ordinal = 0; ordinal < Lotto.NUMBER_OF_NUMBERS; ordinal++) {
            if (purchasedLotto.getNumbers().contains(winningLotto.getNumbers().get(ordinal))) {
                count++;
            }
        }
        return count;
    }

    public List<Integer> compareLottoTable(List<Lotto> lottoTable, Lotto winningLotto, int bonusNumber) {
        validateBounusNumber(winningLotto, bonusNumber);
        List<Integer> countGroup = new ArrayList<>();
        for (int row = 0; row < lottoTable.size(); row++) {
            int count = 0;
            count = compare(lottoTable.get(row), winningLotto);
            if (count == Grade.THIRD.getCount() && hasBonusNumber(lottoTable.get(row), bonusNumber)) {
                count = Grade.SECOND.getCount();
            }
            countGroup.add(count);
        }
        return countGroup;
    }

    public List<Integer> toResult(List<Integer> countGroup) {
        List<Integer> result = new ArrayList<>();
        for (int count = Grade.FIFTH.getCount(); count <= Grade.FIRST.getCount(); count++) {
            result.add(Collections.frequency(countGroup, count));
            if (count == Grade.THIRD.getCount()) {
                result.add(Collections.frequency(countGroup, Grade.SECOND.getCount()));
            }
        }
        result.add(countGroup.size());
        return result;
    }

    public boolean hasBonusNumber(Lotto lotto, int bonunsNumber) {
        return lotto.getNumbers().contains(bonunsNumber);
    }

    public void validateBounusNumber(Lotto winningLotto, int bonusNumber) {
        if (bonusNumber > Lotto.MAX_NUMBER || bonusNumber < Lotto.MIN_NUMBER) {
            throw new IllegalArgumentException(Ouput.MUST_BE_NUMBERS_BETWEEN_1_TO_45_ERROR);
        }
        if (hasBonusNumber(winningLotto, bonusNumber)) {
            throw new IllegalArgumentException(Ouput.HAD_DUPLICATE_NUMBER_ERROR);
        }
    }
}
