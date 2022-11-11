package lotto.domain;

import java.util.List;

import lotto.utils.Validator;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public boolean checkContainBonusNumber(List<Integer> purchasedLotto) {
        return purchasedLotto.contains(bonusNumber);
    }

    private void validate(int bonusNumber) {
        Validator.isInRange(bonusNumber);
    }
}
