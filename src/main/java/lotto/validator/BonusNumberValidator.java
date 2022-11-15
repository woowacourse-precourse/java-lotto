package lotto.validator;

import lotto.model.Lotto;
import lotto.exception.ExceptionType;

import java.util.List;

public class BonusNumberValidator {
    public static void validate(Lotto lotto, String bonusNumber) {
        validateType(bonusNumber);
        validateDuplicate(lotto.getNumbers(), bonusNumber);
    }

    private static void validateDuplicate(List<Integer> lotto, String bonusNumber) {
        if (lotto.contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException(ExceptionType.BONUS_DUPLICATE_EXCEPTION.getMessage());
        }
    }

    public static void validateType(String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionType.BONUS_INPUT_TYPE_EXCEPTION.getMessage());
        }
    }
}
