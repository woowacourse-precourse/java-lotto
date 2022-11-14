package lotto.domain;

import constants.ExceptionMessage;
import constants.LottoGame;

public class BonusBall {

    private final int bonusBall;

    public BonusBall(int bonusBall) {
        validate(bonusBall);
        this.bonusBall = bonusBall;
    }

    public void validate(int bonusNumber) {
        if (!(bonusNumber >= LottoGame.LOTTO_MIN_RANGE && bonusNumber <= LottoGame.LOTTO_MAX_RANGE)) {
            throw new IllegalArgumentException(ExceptionMessage.WITHIN_RANGE);
        }
    }

    public boolean isSame(int number) {
        return this.bonusBall == number;
    }

    public boolean isMatchLotto(Lotto lotto) {
        return lotto.contains(bonusBall);
    }

}
