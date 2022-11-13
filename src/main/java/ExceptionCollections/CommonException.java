package ExceptionCollections;

import enumCollections.Exceptions;

public class CommonException {
    public static final String REGULAR_EXPRESSION = "^[0-9]*$";
    static final int PRICE_PER_LOTTO = 1000;

    public static void hasCharacters(String number) {
        if (!number.contains(REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException(Exceptions.getMessage(Exceptions.CHARACTER_INCLUDED));
        }
    }

    public static void validatePaymentUnit(int payment) {
        if (payment % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException(Exceptions.getMessage(Exceptions.WRONG_MONEY_UNIT));
        }
    }
}
