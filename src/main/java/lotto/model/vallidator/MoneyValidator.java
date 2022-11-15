package lotto.model.vallidator;

import lotto.model.Constants;

public class MoneyValidator {
    public static void validate(int number){
        isPositive(number);
        isMultiplePrice(number);
    }

    private static void isPositive(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(MoneyError.MONEY_POSITIVE.message());
        }
    }

    private static void isMultiplePrice(int number) {
        if (number % Constants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(MoneyError.MONEY_MOD.message());
        }
    }
}
