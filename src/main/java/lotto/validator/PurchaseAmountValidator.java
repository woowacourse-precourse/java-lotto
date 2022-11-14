package lotto.validator;

import static lotto.validator.ExceptionStatus.NO_DIGIT;
import static lotto.validator.ExceptionStatus.NO_THOUSAND_UNIT;

public class PurchaseAmountValidator {
    private static final int LOTTO_PURCHASE_PRICE_UNIT = 1000;
    private static final int ZERO = 0;

    public static void validate(String money) {
        if (!isDigit(money)) {
            throw new IllegalArgumentException(NO_DIGIT.getMessage());
        }
        if (!isThousandUnit(money)) {
            throw new IllegalArgumentException(NO_THOUSAND_UNIT.getMessage());
        }
    }

    private static boolean isDigit(String money) {
        return money.chars().allMatch(Character::isDigit);
    }

    private static boolean isThousandUnit(String money) {
        return Integer.parseInt(money) % LOTTO_PURCHASE_PRICE_UNIT == ZERO && Integer.parseInt(money) != ZERO;
    }
}
