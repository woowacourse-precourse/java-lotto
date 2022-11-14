package models.validation;

import constants.LottoConstant;
import models.Lotto;
import system.process.exception.IllegalArgument;
import utils.IsCollection;

public class WinningLottoValidation {
    public static void validateBonusNumber(Lotto lotto, int bonusNumber) {
        validateInRange(bonusNumber);
        validateDuplication(lotto, bonusNumber);
    }

    private static void validateInRange(int bonusNumber) {
        if (IsCollection.isNumberInRange(bonusNumber, LottoConstant.NUMBER_START, LottoConstant.NUMBER_END)) {
            return;
        }
        IllegalArgument.handleException(IllegalArgument.NOT_IN_RANGE.getMessage());
    }

    private static void validateDuplication(Lotto lotto, int bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            IllegalArgument.handleException(IllegalArgument.DUPLICATION.getMessage());
        }
    }
}
