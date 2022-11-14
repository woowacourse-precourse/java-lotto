package lotto.util;

import lotto.domain.Money;
import lotto.exception.InvalidNumberException;
import lotto.exception.money.MoneyStartZeroNumberException;

public class MoneyConverter {
    private static final String START_ZERO_REGEX = "^0[0-9]+";

    public static Money convert(String money) {
        validate(money);
        return new Money(Integer.parseInt(money));
    }

    private static void validate(String input) {
        validateNumber(input);
        validateStartZeroNumber(input);
    }

    private static void validateNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberException();
        }
    }

    private static void validateStartZeroNumber(String input) {
        if (input.matches(START_ZERO_REGEX)) {
            throw new MoneyStartZeroNumberException();
        }
    }
}
