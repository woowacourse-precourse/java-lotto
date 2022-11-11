package lotto.domain;

import constants.ExceptionMessage;
import constants.LottoGame;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber) {
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public void validate(int bonusNumber) {
        if (bonusNumber < LottoGame.LOTTO_MIN_RANGE || bonusNumber > LottoGame.LOTTO_MAX_RANGE) {
            throw new IllegalArgumentException(ExceptionMessage.WITHIN_RANGE);
        }
    }

    public boolean isSame(int number) {
        return this.bonusNumber == number;
    }

    public boolean isMatch(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }

}
