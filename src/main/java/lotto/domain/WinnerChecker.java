package lotto.domain;

import lotto.ui.Error;

import java.util.ArrayList;
import java.util.List;

public class WinnerChecker {
    public int compareLottoNumbers(Lotto purchasedLotto, Lotto winningLotto) {
        int numberOfMatches = 0;
        for (int i = 0; i < winningLotto.getNumbers().size(); i++) {
            if (purchasedLotto.getNumbers().contains(winningLotto.getNumbers().get(i))) {
                numberOfMatches++;
            }
        }
        return numberOfMatches;
    }

    public boolean hasBonusNumber(Lotto lotto, int bonunsNumber) {
        return lotto.getNumbers().contains(bonunsNumber);
    }

    public void validateBounusNumber(Lotto winningLotto, int bonusNumber) {
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException(Error.MUST_BE_NUMBERS_BETWEEN_1_TO_45);
        }
        if (hasBonusNumber(winningLotto, bonusNumber)) {
            throw new IllegalArgumentException(Error.HAD_DUPLICATE_NUMBER);
        }
    }

    public List<Integer> compareLottoTable(List<Lotto> lottoTable, Lotto winningLotto, int bonusNumber) {
        validateBounusNumber(winningLotto, bonusNumber);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < lottoTable.size(); i++) {
            int numberOfMatches = 0;
            numberOfMatches = compareLottoNumbers(lottoTable.get(i), winningLotto);
            if (numberOfMatches == 5 && hasBonusNumber(lottoTable.get(i), bonusNumber)) {
                numberOfMatches += 10;
            }
            result.add(numberOfMatches);
        }
        return result;
    }


}
