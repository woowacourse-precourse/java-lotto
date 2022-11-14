package lotto.domain;

import lotto.validator.LottoValidator;

public class WinningNumber {

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningNumber(Lotto winningNumbers, int bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.lotto = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validate(Lotto lotto, int bonusNumber) {
        LottoValidator.checkBonusNumber(lotto.getNumbers(), bonusNumber);
    }
}
