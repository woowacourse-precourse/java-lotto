package lotto.domain;

import lotto.domain.errorenum.Error;
import lotto.domain.lottoenum.LottoCondition;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validateInRange(bonusNumber);
        validateDuplicateWithLotto(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateInRange(int bonusNumber) {
        if (bonusNumber >= LottoCondition.MIN.getValue() && bonusNumber <= LottoCondition.MAX.getValue()) {
            return;
        }
        throw new IllegalArgumentException(Error.NOT_IN_RANGE.getCode());
    }

    private void validateDuplicateWithLotto(Lotto lotto, int bonusNumber) {
        if (lotto.getSortedNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(Error.BONUS_NUMBER_DUPLICATE.getCode());
        }
    }
}
