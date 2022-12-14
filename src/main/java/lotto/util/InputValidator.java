package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.message.ErrorMessage;

public class InputValidator {
    private static final int LOTTO_PRICE = 1000;
    private static final String WINNING_NUMBER_REGEX = "^([0-9]*,){5}[0-9]*$";
    public static final String COMMA = ",";

    private InputValidator() {
    }

    public static int validateBuyingPrice(final String userInput) {
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

    public static List<Integer> validateWinningNumber(final String userInput) {
        if (!userInput.matches(WINNING_NUMBER_REGEX)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_WINNING_NUMBER);
        }
        return Arrays.stream(userInput.split(COMMA))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int validateBonusNumber(final String userInput) {
        if (!isNumeric(userInput)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMERIC_ERROR);
        }
        return Integer.parseInt(userInput);
    }
}
