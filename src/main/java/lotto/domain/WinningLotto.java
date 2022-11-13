package lotto.domain;

import static lotto.constant.LottoGameRule.LOTTO_MAX_NUMBER;
import static lotto.constant.LottoGameRule.LOTTO_MIN_NUMBER;
import static lotto.domain.ErrorMessage.BONUS_NUMBER_SIZE_ERROR;
import static lotto.domain.ErrorMessage.OUT_OF_RANGE_NUMBER_ERROR;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumber, int bonusNumber) {
        this.winningLotto = winningNumber;
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        isOneNumber(bonusNumber);
        isInRange(bonusNumber);
        isDuplicate(bonusNumber);
    }

    private void isOneNumber(int bonusNumber) {
        if ((int)(Math.log10(bonusNumber)+1) != 1) {
            throw new IllegalArgumentException((BONUS_NUMBER_SIZE_ERROR.toString()));
        }
    }

    private void isInRange(int bonusNumber) {
        if (!(bonusNumber >= LOTTO_MIN_NUMBER && bonusNumber <= LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER_ERROR.toString());
        }
    }

    private void isDuplicate(int bonusNumber) {

    }

}
