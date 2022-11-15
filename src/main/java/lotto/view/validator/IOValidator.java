package lotto.view.validator;

import lotto.view.constants.ErrorMessage;

public class IOValidator {
    private static final String REGEX_INTEGER = "^[^0]\\d*";

    public IOValidator() { }

    public static void validateFormattedStringToInteger(String value, String delimiter) {
        String delimiterRemoved = value.replaceAll(delimiter, "");
        if (value.length() == delimiterRemoved.length()) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_ILLEGAL_FORMAT.getValue());
        }
        if (!delimiterRemoved.matches(REGEX_INTEGER)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_CONTAINS_NOT_INTEGER.getValue());
        }
        if (value.contains(delimiter + "0")) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_START_WITH_ZERO.getValue());
        }
    }

    public static void validateStringToInteger(String value) {
        if (!value.matches(REGEX_INTEGER)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_NOT_INTEGER.getValue());
        }
    }

    public static void validateMessage(Object message) {
        if (message == null) {
            throw new NullPointerException(ErrorMessage.OUTPUT_NULL_POINTER.getValue());
        }
    }
}
