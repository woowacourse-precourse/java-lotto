package lotto.domain;

import lotto.utils.IntegerConvertor;

import java.util.List;

import static lotto.utils.ErrorMessages.*;

public class BonusNumber {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private final int number;

    public BonusNumber(String number, WinningLotto winningLotto) {
        int bonusNumber = toInteger(number);
        validate(bonusNumber, winningLotto);
        this.number = bonusNumber;
    }

    private int toInteger(String number) {
        return IntegerConvertor.toInteger(number, BONUS_NUMBER_NOT_INTEGER);
    }

    private void validate(int number, WinningLotto winningLotto) {
        validateRange(number);
        validateDuplicatedByWinningNumbers(number, winningLotto);
    }

    private void validateRange(int number) {
        if (number < MIN_RANGE || number > MAX_RANGE) {
            throw new IllegalArgumentException(BONUS_NUMBER_OUT_OF_RANGE);
        }
    }

    private void validateDuplicatedByWinningNumbers(int number, WinningLotto winningLotto) {
        if (winningLotto.contain(number)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATED);
        }
    }

    public boolean isMatchBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(number);
    }
}
