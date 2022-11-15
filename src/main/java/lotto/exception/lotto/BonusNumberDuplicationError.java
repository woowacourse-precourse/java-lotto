package lotto.exception.lotto;

import static lotto.constant.ErrorMessage.BONUS_NUMBER_DUPLICATION;

import lotto.exception.BaseException;

public class BonusNumberDuplicationError extends BaseException {

    public BonusNumberDuplicationError() {
        super(BONUS_NUMBER_DUPLICATION);
    }
}
