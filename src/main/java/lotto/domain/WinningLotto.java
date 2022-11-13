package lotto.domain;

import java.util.List;
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

    public int countMatchingNumbers(List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream()
                .filter(lotto.getNumbers()::contains)
                .count();
    }

    public boolean isContainingBonusNumber(List<Integer> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }

    private void validateInRange(int bonusNumber) {
        if (bonusNumber >= LottoCondition.MIN.getValue() && bonusNumber <= LottoCondition.MAX.getValue()) {
            return;
        }
        throw new IllegalArgumentException(Error.NOT_IN_RANGE.getCode());
    }

    private void validateDuplicateWithLotto(Lotto lotto, int bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(Error.BONUS_NUMBER_DUPLICATE.getCode());
        }
    }
}
