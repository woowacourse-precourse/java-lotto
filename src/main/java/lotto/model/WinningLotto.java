package lotto.model;

import lotto.Constants;

public class WinningLotto {

    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto lotto, int bonusNumber) {
        isInRange(bonusNumber);
        isUnique(lotto, bonusNumber);
    }

    private void isInRange(int bonusNumber) {
        if (bonusNumber < Constants.NUMBER_RANGE_START || bonusNumber > Constants.NUMBER_RANGE_END) {
            throw new IllegalArgumentException(BonusError.RANGE.message());
        }
    }

    private void isUnique(Lotto lotto, int bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(BonusError.UNIQUE.message());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }
}
