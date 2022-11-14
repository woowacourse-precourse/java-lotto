package lotto.domain;

import lotto.data.Error;

import java.util.List;

import static lotto.data.LottoInfo.*;

public class ExceptionHandler {

    public static void checkOutOfRange(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.get(0) < START_NUMBER.getValue() || numbers.get(numbers.size() - 1) > END_NUMBER.getValue()) {
            throw new IllegalArgumentException(Error.OUT_OF_RANGE.getMessage());
        }
    }

    public static void checkOutOfRange(int number) throws IllegalArgumentException {
        if (number < START_NUMBER.getValue() || number > END_NUMBER.getValue()) {
            throw new IllegalArgumentException(Error.OUT_OF_RANGE.getMessage());
        }
    }

    public static void checkNumeric(String input) throws IllegalArgumentException {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(Error.NOT_NUMERIC.getMessage());
        }
    }

    private static boolean isNumeric(String input) {
        return input != null && input.matches("^[0-9,]*$");
    }

    public static void checkDuplicateNumber(List<Integer> numbers) throws IllegalArgumentException {
        int distinctSize = (int) numbers.stream()
                .distinct()
                .count();

        if (numbers.size() != distinctSize) {
            throw new IllegalArgumentException(Error.DUPLICATE_NUMBER.getMessage());
        }
    }

    public static void checkInvalidSize(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error.INVALID_SIZE.getMessage());
        }
    }

    public static void checkNotDivisibleByThousand(int price) throws IllegalArgumentException {
        if (price % PRICE_UNIT.getValue() > 0) {
            throw new IllegalArgumentException(Error.NOT_DIVISIBLE_BY_THOUSAND.getMessage());
        }
    }
}
