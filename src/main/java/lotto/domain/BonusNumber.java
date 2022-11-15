package lotto.domain;

import lotto.constants.ErrorMessages;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(Lotto winningLotto, int bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningLotto, int bonusNumber) {
        validateNumber(bonusNumber);
        validateDuplicate(winningLotto, bonusNumber);
    }

    private void validateNumber(int bonusNumber) {
        if (!Lotto.isLottoNumber(bonusNumber)) {
            System.out.println(ErrorMessages.NUMBER_RANGE);
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            System.out.println(ErrorMessages.BONUS_DUPLICATE);
            throw new IllegalArgumentException();
        }
    }

    public boolean existIn(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}
