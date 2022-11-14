package lotto.utils.Advice;

import static lotto.domain.model.ErrorMessage.BONUS_NUMBER_INVALID;
import static lotto.domain.model.ErrorMessage.BONUS_NUMBER_OUT_BOUND;
import static lotto.domain.model.ErrorMessage.getErrorMessage;
import static lotto.utils.Advice.LottoValidator.STANDARD_LOTTO_NUMBER;

public abstract class BonusValidator {

    private static final String BONUS_REG_EXP = "\\d{1,2}";
    public static void checkSizeAndNumber(final String bonus) {
        if (!bonus.matches(BONUS_REG_EXP)) {
            throw new IllegalArgumentException(getErrorMessage(BONUS_NUMBER_INVALID) + bonus);
        }
    }

    public static void checkRange(final String bonus) {
        if (!STANDARD_LOTTO_NUMBER.contains(Integer.parseInt(bonus))) {
            throw new IllegalArgumentException(getErrorMessage(BONUS_NUMBER_OUT_BOUND));
        }
    }
}
