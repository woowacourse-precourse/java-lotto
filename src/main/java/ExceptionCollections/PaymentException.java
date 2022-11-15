package ExceptionCollections;

import enumCollections.Exceptions;

public class PaymentException extends CommonException {
    static final int PRICE_PER_LOTTO = 1000;

    public static void validate(String payment) {
        isEmpty(payment);
        hasCharacters(payment);
        validateUnit(stringToInteger(payment));
    }

    private static void validateUnit(int payment) {
        if (payment % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException(Exceptions.getMessage(Exceptions.WRONG_MONEY_UNIT));
        }
    }
}
