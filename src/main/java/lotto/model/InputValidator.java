package lotto.model;

import lotto.Constants;

public class InputValidator {
    public static void checkMoney(String money) {
        isNumber(money);
        isPositive(money);
        isMultiplePrice(money);
    }

    private static void isNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputError.NUMBER.message());
        }
    }

    private static void isPositive(String number) {
        if (Integer.parseInt(number) <= 0) {
            throw new IllegalArgumentException(InputError.MONEY_POSITIVE.message());
        }
    }

    private static void isMultiplePrice(String number) {
        if (Integer.parseInt(number) % Constants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(InputError.MONEY_MOD.message());
        }
    }
}
