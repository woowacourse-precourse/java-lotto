package lotto.view;

import static lotto.util.message.ExceptionMessage.NOT_NUMBER;

public class InputValidator {

    static int validate(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER.get());
        }
    }

}
