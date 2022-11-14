package lotto.utils;

import lotto.view.Output;

public class Validation {

    public static void validateIsNumber(String target) {
        String numberRegex = "^[0-9]*$";
        if (!target.matches(numberRegex)) {
            throw new IllegalArgumentException(ExceptionType.IS_NOT_NUMBER.getMessage());
        }
    }

    public static void validateNumberInLottoRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ExceptionType.NOT_WITHIN_THE_RANGE.getMessage());
        }
    }
}
