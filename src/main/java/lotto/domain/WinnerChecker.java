package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.ui.Ouput;

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

    public List<Integer> sumUpResult(List<Integer> result) {
        List<Integer> sumOfResult = new ArrayList<>();
        for (int i = 3; i <= 6; i++) {
            sumOfResult.add(Collections.frequency(result, i));
            if (i == 5) {
                sumOfResult.add(Collections.frequency(result, 15));
            }
        }
        return sumOfResult;
    }

    public List<Integer> getSumOfResult(List<Lotto> lottoTable, Lotto winningLotto, int bonusNumber) {
        List<Integer> sumOfResult = sumUpResult(compareLottoTable(lottoTable, winningLotto, bonusNumber));
        sumOfResult.add(lottoTable.size());
        return sumOfResult;
    }

    public boolean hasBonusNumber(Lotto lotto, int bonunsNumber) {
        return lotto.getNumbers().contains(bonunsNumber);
    }

    public void validateBounusNumber(Lotto winningLotto, int bonusNumber) {
        if (bonusNumber > 45 || bonusNumber < 1) {
            throw new IllegalArgumentException(Ouput.MUST_BE_NUMBERS_BETWEEN_1_TO_45_ERROR);
        }
        if (hasBonusNumber(winningLotto, bonusNumber)) {
            throw new IllegalArgumentException(Ouput.HAD_DUPLICATE_NUMBER_ERROR);
        }
    }
}
