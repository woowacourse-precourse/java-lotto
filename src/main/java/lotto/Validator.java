package lotto;

import static lotto.ErrorMessage.*;
import static lotto.domain.LottoConst.*;

public final class Validator {
    private Validator() {

    }

    public static void isInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(PREFIX + NOT_INTEGER);
        }
    }

    public static void isNegative(String input) {
        if (Integer.parseInt(input) < 0) {
            throw new IllegalArgumentException(PREFIX + NEGATIVE);
        }
    }

    public static void isDividableWithThousand(String input) {
        if (Integer.parseInt(input) % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PREFIX + NOT_DIVIDABLE_WITH_THOUSAND);
        }
    }

    public static void isValidPurchasePrice(String input) {
        isInteger(input);
        isNegative(input);
        isDividableWithThousand(input);
    }
}
