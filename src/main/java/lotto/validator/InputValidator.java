package lotto.validator;

import lotto.message.ErrorMessage;

public class InputValidator {
    public static int changeStringToInt(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIGIT.getMessage());
        }

        return Integer.parseInt(input);
    }

    private static boolean isNumeric(String input) {
        return input.chars().allMatch(Character::isDigit);
    }
}
