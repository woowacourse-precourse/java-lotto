package lotto.domain;

import static lotto.util.message.ExceptionMessage.NOT_NUMBER;

public class InputValidator {

    public static int validate(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER.get());
        }
    }

}
