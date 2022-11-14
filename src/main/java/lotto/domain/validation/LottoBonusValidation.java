package lotto.domain.validation;

import lotto.domain.Lotto;
import lotto.domain.LottoEnum;
import lotto.view.validation.ExceptionMessage;

public class LottoBonusValidation {
    private static final String NUMBER_REGEXP = "^[0-9]+$";
    public static void validate(String userInput) {
        validateOnlyNumber(userInput);
        int bonus = Integer.parseInt(userInput);
        validateNumberRange(bonus);
    }

    public static void validateDuplicateNumber(Lotto lotto, String bonus) {
        if (lotto.containBonusNumber(Integer.valueOf(bonus))) {
            throw new IllegalArgumentException();
        }
    }

    private static void validateOnlyNumber(String userInput) {
        if (!userInput.matches(NUMBER_REGEXP)) {
            throw new IllegalArgumentException(ExceptionMessage.ONLY_NUMBER.toString());
        }
    }

    private static void validateNumberRange(int bonus) {
        if (!LottoEnum.isNumberInRange(bonus)) {
            throw new IllegalArgumentException(ExceptionMessage.NUMBER_RANGE.toString());
        }
    }
}
