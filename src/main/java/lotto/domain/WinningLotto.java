package lotto.domain;

import static lotto.constant.LottoGameRule.LOTTO_MAX_NUMBER;
import static lotto.constant.LottoGameRule.LOTTO_MIN_NUMBER;
import static lotto.utils.ErrorMessage.BONUS_NUMBER_DUPLICATED_ERROR;
import static lotto.utils.ErrorMessage.OUT_OF_RANGE_NUMBER_ERROR;

public class WinningLotto {
    private final Lotto winningLotto;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumber, int bonusNumber) {
        this.winningLotto = winningNumber;
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        isInRange(bonusNumber);
        isDuplicate(bonusNumber);
    }

    private void isInRange(int bonusNumber) {
        if (!(bonusNumber >= LOTTO_MIN_NUMBER && bonusNumber <= LOTTO_MAX_NUMBER)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_NUMBER_ERROR.toString());
        }
    }

    private void isDuplicate(int bonusNumber) {
        if (this.winningLotto.isContainBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATED_ERROR.toString());
        }
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}