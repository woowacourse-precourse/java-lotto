package lotto.domain;

import lotto.constant.Constant;
import lotto.utils.Validation;

public class BonusNumber {
    private int bonusNumber;

    public BonusNumber(String input) {
        Validation.validateCheckNumeric(input, Constant.SPLIT_FOR_MONEY);
        Validation.validateFirstNumberIsNotZero(input);
        Validation.validateNumberInRange(input);
        bonusNumber = Integer.parseInt(input);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
