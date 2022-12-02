package lotto.util;

import java.util.regex.Pattern;

public abstract class Validator {
    private static final Pattern NUMBER_REGEX = Pattern.compile("^[0-9]*$");

    abstract void validate(String userInput) throws IllegalArgumentException;

    static String removeSpace(String input) {
        return input.replaceAll(" ", "");
    }
    void validateNumber(String budget) {
        if (!NUMBER_REGEX.matcher(budget).matches()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_NOT_NUMERIC.getMessage());
        }
    }
}
