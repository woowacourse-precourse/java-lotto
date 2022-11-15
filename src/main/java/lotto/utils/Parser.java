package lotto.utils;

import static lotto.enumtype.LottoValidationMsg.NOT_FORMATTING_EXCEPTION;

public class Parser {

    public static int parseInt(String input) {
        isParsable(input);
        return Integer.parseInt(input);
    }

    private static void isParsable(String input) {
        if (!validateFormatNumber(input)) {
            throw new NumberFormatException(NOT_FORMATTING_EXCEPTION.getMessage());
        }
    }

    private static boolean validateFormatNumber(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
