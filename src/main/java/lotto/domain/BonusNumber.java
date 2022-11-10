package lotto.domain;

import lotto.utils.Validator;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        Validator.validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }
}
