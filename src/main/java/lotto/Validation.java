package lotto;

import java.util.regex.Pattern;

public class Validation {
    private static final String regex = "^[0-9]*$";

    public Validation() {
    }

    public void validateNumber(String input) {
        if (!Pattern.matches(regex, input)) {
            throw new IllegalArgumentException(Errors.NOT_INCLUDE_CHARACTER.toString());
        }
    }

    public void validateNumberRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(Errors.OUT_OF_RANGE.toString());
        }
    }
}
