package lotto.util;

import lotto.domain.errorenum.LottoError;

public class InputValidator {
    private static final String WINNING_NUMBER_REGEX = "[0-9,]+";

    private InputValidator() {
    }

    public static void validateWinningNumberDelimiter(String input) {
        if (!input.matches(WINNING_NUMBER_REGEX)) {
            throw new IllegalArgumentException(LottoError.WRONG_DELIMITER.printError());
        }
    }

    public static int validateParsingInteger(String input) {
        int value;
        try {
            value = Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(LottoError.ACCEPT_ONLY_NUMBER.printError());
        }
        return value;
    }


}
