package lotto;

import java.util.List;

import static lotto.Error.BONUS_NUMBER_DUPLICATED_ERROR;
import static lotto.Error.BONUS_NUMBER_RANGE_ERROR;

public class BonusNumber {
    public int bonusNumber;

    public BonusNumber(int bonusNumber, List<Integer> winNumbers) {
        checkRange(bonusNumber);
        checkDuplicated(bonusNumber, winNumbers);
        this.bonusNumber = bonusNumber;
    }

    private void checkRange(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(BONUS_NUMBER_RANGE_ERROR.getMessage());
        }
    }

    private void checkDuplicated(int bonusNumber, List<Integer> winNumbers) {
        for (Integer winNumber : winNumbers) {
            if (winNumber.equals(bonusNumber)) {
                throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATED_ERROR.getMessage());
            }
        }
    }
}
