package lotto.validator;

import lotto.domain.Lotto;

import static lotto.validator.ExceptionStatus.*;

public class BonusNumberValidator {

    public static void validate(String bonusNumber, Lotto winLotto) {
        LottoValidator.validateCorrectRange(Integer.parseInt(bonusNumber));
        validateContainBonusNumber(bonusNumber, winLotto);
    }

    private static void validateContainBonusNumber(String bonusNumber, Lotto winLotto) {
        if (winLotto.getNumbers().contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(NO_CONTAIN_WINNING_LOTTO_NUMBERS.getMessage());
        }
    }
}
