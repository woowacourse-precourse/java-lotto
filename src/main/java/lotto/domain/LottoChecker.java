package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.ui.Ouput;

public class LottoChecker {

    enum Grade {
        FIFTH(3),
        FOURTH(4),
        THIRD(5),
        SECOND(5 + 10),
        FIRST(6);

        private final int count;

        Grade(int count) {
            this.count = count;
        }
    }

    public int compare(Lotto purchasedLotto, Lotto winningLotto) {
        int count = 0;
        for (int column = 0; column < Lotto.NUMBER_OF_NUMBERS; column++) {
            if (purchasedLotto.getNumbers().contains(winningLotto.getNumbers().get(column))) {
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
            if (count == Grade.THIRD.count && hasBonusNumber(lottoTable.get(row), bonusNumber)) {
                count = Grade.SECOND.count;
            }
            countGroup.add(count);
        }
        return countGroup;
    }

    public List<Integer> toResult(List<Integer> countGroup) {
        List<Integer> result = new ArrayList<>();
        for (int count = Grade.FIFTH.count; count <= Grade.FIRST.count; count++) {
            result.add(Collections.frequency(countGroup, count));
            if (count == Grade.THIRD.count) {
                result.add(Collections.frequency(countGroup, Grade.SECOND.count));
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
