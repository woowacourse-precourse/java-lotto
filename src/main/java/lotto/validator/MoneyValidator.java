package lotto.validator;

import lotto.exception.ExceptionType;

public class MoneyValidator {
    public static void validate(String money) {
        validateType(money);
        validateValue(Integer.parseInt(money));
    }

    public static void validateType(String money) {
        try {
            Integer.parseInt(money);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionType.MONEY_TYPE_EXCEPTION.getMessage());
        }
    }

    public static void validateValue(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionType.MONEY_VALUE_EXCEPTION.getMessage());
        }
    }
}
