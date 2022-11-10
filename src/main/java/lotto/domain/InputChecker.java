package lotto.domain;

import static lotto.view.Constants.*;

public class InputChecker {
    public void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC);
        }
    }
}
