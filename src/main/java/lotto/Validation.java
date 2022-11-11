package lotto;

import java.util.regex.Pattern;

public class Validation {
    private static final String regex = "^[0-9]*$";

    public Validation() {
    }

    private void validateNumber(String input) {
        if (!Pattern.matches(regex, input)) {
            throw new IllegalArgumentException(Errors.NOT_INCLUDE_CHARACTER.toString());
        }
    }

    public void validatePrice(String input) {
        validateNumber(input);

        int price = Integer.parseInt(input);
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(Errors.NOT_DIVIDE_BY_1000.toString());
        }
    }
}
