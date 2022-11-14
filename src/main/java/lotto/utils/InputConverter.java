package lotto.utils;

import lotto.exception.ErrorMessage;

public class InputConverter {

    private InputConverter() {

    }

    public static Integer toInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_INPUT_MESSAGE.toString());
        }
    }
}
