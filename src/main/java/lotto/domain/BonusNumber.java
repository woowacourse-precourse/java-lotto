package lotto.domain;

import java.util.List;

import static lotto.utils.ErrorMessages.*;

public class BonusNumber {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private final int number;

    public BonusNumber(String number) {
        validateInteger(number);
        validateRange(number);
        //validateDuplicatedByWinningNumbers(bonusNumber, winningNumbers);
        this.number = Integer.parseInt(number);
    }

    private void validateInteger(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BONUS_NUMBER_NOT_INTEGER);
        }
    }

    private void validateRange(String number) {
        int bonusNumber = Integer.parseInt(number);
        System.out.println(bonusNumber);
        if (bonusNumber < MIN_RANGE || bonusNumber > MAX_RANGE) {
            throw new IllegalArgumentException(BONUS_NUMBER_OUT_OF_RANGE);
        }
    }

    private void validateDuplicatedByWinningNumbers(int bonusNumber, Lotto winningNumbers) {
        List<Integer> numbers = winningNumbers.getNumbers();
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATED);
        }
    }

    public int getNumber() {
        return this.number;
    }
}
