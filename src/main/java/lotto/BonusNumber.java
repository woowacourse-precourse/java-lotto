package lotto;

import static lotto.Error.BONUS_NUMBER_RANGE_ERROR;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        checkRange(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void checkRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(BONUS_NUMBER_RANGE_ERROR.getMessage());
        }
    }
}
