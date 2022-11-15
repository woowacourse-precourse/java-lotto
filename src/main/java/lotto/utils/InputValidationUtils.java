package lotto.utils;

import static lotto.validator.ErrorMessage.DIVISIBLE_WITH_THOUSAND;
import static lotto.validator.ErrorMessage.NOT_ENOUGH_MONEY;
import static lotto.validator.ErrorMessage.INVALID_FORMAT;


public class InputValidationUtils {

    private static final int MIN_PRICE = 1000;

    public static void validatePrice(final int price) {
        validateDivisible(price);
        validateRange(price);
    }

    private static void validateDivisible(final int price) {
        if (!isDivisibleWithThousand(price)) {
            System.out.println(DIVISIBLE_WITH_THOUSAND.message());
            throw new IllegalArgumentException(
                DIVISIBLE_WITH_THOUSAND.message()
            );
        }
    }

    private static boolean isDivisibleWithThousand(final int price) {
        return price != 0 && price % MIN_PRICE == 0;
    }

    private static void validateRange(final int price) {
        if (price < MIN_PRICE) {
            System.out.println(NOT_ENOUGH_MONEY.message());
            throw new IllegalArgumentException(
                NOT_ENOUGH_MONEY.message());
        }
    }

    public static void validateNumbers(final String[] splitNumbers) {
        for (String splitNumber : splitNumbers) {
            validateFormat(splitNumber);
        }
    }

    public static void validateFormat(final String input) {
        if (!isNumber(input)) {
            System.out.println(INVALID_FORMAT.message());
            throw new IllegalArgumentException(
                INVALID_FORMAT.message());
        }
    }

    private static boolean isNumber(final String input) {
        return input.matches("[0-9]+");
    }
}
