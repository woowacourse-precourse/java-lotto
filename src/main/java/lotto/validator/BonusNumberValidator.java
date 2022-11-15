package lotto.validator;

import lotto.domain.Lotto;

import static lotto.validator.ExceptionStatus.NO_CONTAIN_WINNING_LOTTO_NUMBERS;
import static lotto.validator.ExceptionStatus.NO_DIGIT;

public class BonusNumberValidator {

    public static void validate(String bonusNumber, Lotto winLotto) {
        validateDigit(bonusNumber);
        LottoValidator.validateCorrectRange(Integer.parseInt(bonusNumber));
        validateContainBonusNumber(bonusNumber, winLotto);
    }

    private static void validateDigit(String bonusNumber) {
        if (!bonusNumber.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException(NO_DIGIT.getMessage());
        }
    }

    private static void validateContainBonusNumber(String bonusNumber, Lotto winLotto) {
        if (winLotto.getNumbers().contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(NO_CONTAIN_WINNING_LOTTO_NUMBERS.getMessage());
        }
    }
}
