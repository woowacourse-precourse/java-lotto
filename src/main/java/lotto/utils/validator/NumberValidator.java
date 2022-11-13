package lotto.utils.validator;

import static lotto.utils.Exceptions.NOT_NATURAL_NUMBER;

public class NumberValidator {
    public static void checkNaturalNumber(String string) {
        if (!string.matches("[1-9][0-9]*")) {
            throw new IllegalArgumentException(NOT_NATURAL_NUMBER.toString());
        }
    }
}