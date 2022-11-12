package lotto.domain;

import lotto.validator.InputValidator;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(Lotto lotto, int bonusNumber) {
        InputValidator.validateNumberRange(bonusNumber);
        InputValidator.validateOverlappingBonusNumbers(lotto.getNumbers(), bonusNumber);
    }
}
