package lotto.domain;

import java.util.List;
import lotto.domain.errorenum.LottoError;
import lotto.util.LottoNumberValidator;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validate(lotto, bonusNumber);
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

    private void validate(Lotto lotto, int bonusNumber) {
        LottoNumberValidator.validateInRange(bonusNumber);
        validateBonusNumberDuplicate(lotto.getNumbers(), bonusNumber);
    }

    private void validateBonusNumberDuplicate(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(LottoError.BONUS_NUMBER_DUPLICATE.printError());
        }
    }
}
