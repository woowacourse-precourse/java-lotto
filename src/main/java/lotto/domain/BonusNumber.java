package lotto.domain;

import java.util.List;

import static lotto.utils.ErrorMessages.*;

public class BonusNumber {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private final int number;

    public BonusNumber(String number, WinningLotto winningLotto) {
        validateInteger(number);
        int bonusNumber = Integer.parseInt(number);
        validateRange(bonusNumber);
        validateDuplicatedByWinningNumbers(bonusNumber, winningLotto);
        this.number = bonusNumber;
    }

    private void validateInteger(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BONUS_NUMBER_NOT_INTEGER);
        }
    }

    private void validateRange(int number) {
        if (number < MIN_RANGE || number > MAX_RANGE) {
            throw new IllegalArgumentException(BONUS_NUMBER_OUT_OF_RANGE);
        }
    }

    private void validateDuplicatedByWinningNumbers(int number, WinningLotto winningLotto) {
        List<Integer> winningNumbers = getLotto(winningLotto).getNumbers();
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATED);
        }
    }

    private Lotto getLotto(WinningLotto winningNumbers) {
        return winningNumbers.getWinningNumbers();
    }

    public boolean isMatchBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(number);
    }

    public int getNumber() {
        return this.number;
    }
}
