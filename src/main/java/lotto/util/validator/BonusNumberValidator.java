package lotto.util.validator;

import lotto.util.Constants;
import lotto.util.Utils;

public class BonusNumberValidator {
    private String bonusNumber;

    public BonusNumberValidator(String bonusNumber) {
        this.bonusNumber = bonusNumber;
        isIntBonus();
        isBonusDuplicated();
        isBonusCorrectRange();
    }

    private void isIntBonus() {
        try {
            Utils.convertToInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Constants.ERROR_BONUS_NUMBER_INT);
        }
    }

    private void isBonusDuplicated() {
        if (Utils.isContain(bonusNumber, Utils.convertToList(bonusNumber))) {
            throw new IllegalArgumentException(Constants.ERROR_BONUS_NUMBER_DUPLICATED);
        }
    }

    private void isBonusCorrectRange() {
        int check = Utils.convertToInt(bonusNumber);

        if ((check > 45) || (check < 1)) {
            throw new IllegalArgumentException(Constants.ERROR_BONUS_NUMBER_Range);
        }
    }

}
