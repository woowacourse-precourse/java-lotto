package lotto.exception;

import static lotto.constant.ErrorMessage.BONUS_NUMBER_DUPLICATION;

public class BonusNumberDuplicationError extends BaseException {

    public BonusNumberDuplicationError() {
        super(BONUS_NUMBER_DUPLICATION);
    }
}
