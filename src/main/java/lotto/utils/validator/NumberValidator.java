package lotto.utils.validator;

import lotto.utils.Error;

public class NumberValidator {
    public static void checkNaturalNumber(String string) {
        if (!string.matches("[1-9][0-9]*")) {
            System.out.println(Error.NOT_NATURAL_NUMBER);
            throw new IllegalArgumentException();
        }
    }
}
