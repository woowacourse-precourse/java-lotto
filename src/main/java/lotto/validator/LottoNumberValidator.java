package lotto.validator;

import lotto.constant.ErrorMessage;
import lotto.domain.Lotto;

public class LottoNumberValidator {

    public static void validateBonusNumberAndLottoAreDuplicate(Lotto lotto, int bonusNumber) {
        if (lotto.isContains(bonusNumber)) {
            throw new IllegalArgumentException(
                    ErrorMessage.BONUS_NUMBER_AND_WINNING_LOTTO_NUMBERS_ARE_DUPLICATE.getMessage()
            );
        }
    }

}
