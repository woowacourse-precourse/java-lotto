package lotto.domain;

import lotto.exception.InvalidNumberException;
import lotto.exception.winningnumber.WinningNumberDuplicatedNumberException;
import lotto.exception.winningnumber.WinningNumberFormatException;
import lotto.exception.winningnumber.WinningNumberRangeException;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WinningNumber {
    private static final String DELIMITER = ",";
    private static final int LOTTO_LOWER_NUMBER = 1;
    private static final int LOTTO_UPPER_NUMBER = 45;
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningNumber(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        validateDuplicatedNumber(bonusNumber);
        validateNumberRange(bonusNumber);
    }

    private void validateDuplicatedNumber(int number) {
        if (winningLotto.containNumber(number)) {
            throw new WinningNumberDuplicatedNumberException();
        }
    }

    private void validateNumberRange(int number) {
        if ((number < LOTTO_LOWER_NUMBER) || (number > LOTTO_UPPER_NUMBER)) {
            throw new WinningNumberRangeException(LOTTO_LOWER_NUMBER, LOTTO_UPPER_NUMBER);
        }
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
