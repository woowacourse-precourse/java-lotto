package lotto.domain;

import lotto.utils.Validator;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        Validator.isInRange(bonusNumber);
    }
}
