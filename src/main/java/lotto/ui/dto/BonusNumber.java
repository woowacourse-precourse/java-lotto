package lotto.ui.dto;

import lotto.util.Validator;

public class BonusNumber {

    private final String bonusNumber;

    public BonusNumber(String bonusNumber, Validator validator) {
        validator.validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }
}
