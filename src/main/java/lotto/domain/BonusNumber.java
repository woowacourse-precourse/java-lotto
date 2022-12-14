package lotto.domain;

import lotto.domain.enums.LottoNumberStatus;

public class BonusNumber {
    private final int bonusNumber;

    public BonusNumber(final int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(final int bonusNumber) {
        LottoNumberStatus.validateLottoNumber(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
