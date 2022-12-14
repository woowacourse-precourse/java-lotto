package lotto.util;

import lotto.message.ErrorMessage;

public class InputValidator {

    public static final int LOTTO_PRICE = 1000;

    private InputValidator() {
    }

    public static int validateInputPrice(final String userInput) {
        int price;
        if (!isNumeric(userInput)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMERIC_ERROR);
        }
        price = Integer.parseInt(userInput);
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_PRICE);
        }
        return price;
    }

    private static boolean isNumeric(final String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException exception) {
            return false;
        }
        return true;
    }
}
