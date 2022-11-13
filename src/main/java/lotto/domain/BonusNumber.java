package lotto.domain;

import java.util.List;

import static lotto.utils.ErrorMessages.BONUS_NUMBER_DUPLICATED;
import static lotto.utils.ErrorMessages.BONUS_NUMBER_OUT_OF_RANGE;

public class BonusNumber {
    private final int number;

    public BonusNumber(String number, Lotto winningNumbers) {
        int bonusNumber = Integer.parseInt(number);
        validateRange(bonusNumber);
        this.number = bonusNumber;
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(BONUS_NUMBER_OUT_OF_RANGE);
        }
    }
}
