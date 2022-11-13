package lotto;

import lotto.Exception.ExceptionType;

public class Validator {
    public static void validateMoneyType(String money) {
        try {
            Integer.parseInt(money);
        } catch (Exception e) {
            throw new IllegalArgumentException(ExceptionType.MONEY_TYPE_EXCEPTION.getMessage());
        }
    }

    public static void validateMoneyValue(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(ExceptionType.MONEY_VALUE_EXCEPTION.getMessage());
        }
    }
}
