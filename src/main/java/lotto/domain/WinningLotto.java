package lotto.domain;

import lotto.model.LottoNumberValidator;

import java.util.List;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
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
