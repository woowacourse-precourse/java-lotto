package ExceptionCollections;

import enumCollections.Exceptions;

import java.util.List;

public class CommonException {
    static final String NUMBER = "^[0-9]*$";
    static final int LOTTO_MINIMUM_NUMBER = 1;
    static final int LOTTO_MAXIMUM_NUMBER = 45;
    static final int PRICE_PER_LOTTO = 1000;

    public static void hasCharacters(String number) {
        if (!number.contains(NUMBER)) {
            throw new IllegalArgumentException(Exceptions.getMessage(Exceptions.CHARACTER_INCLUDED));
        }
    }

    public static void validatePaymentUnit(int payment) {
        if (payment % PRICE_PER_LOTTO != 0) {
            throw new IllegalArgumentException(Exceptions.getMessage(Exceptions.WRONG_MONEY_UNIT));
        }
    }

    public static void validateNumberRange(int number) {
        if (number < LOTTO_MINIMUM_NUMBER || number > LOTTO_MAXIMUM_NUMBER) {
            throw new IllegalArgumentException(Exceptions.getMessage(Exceptions.OUT_OF_NUMBER_RANGE));
        }
    }

    public static void validateNumberLength(List<Integer> numbers, int length) {
        if (numbers.size() != length) {
            throw new IllegalArgumentException(Exceptions.getMessage(Exceptions.WRONG_NUMBER_LENGTH));
        }
    }
}
