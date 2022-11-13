package lotto;

import lotto.data.Error;

import java.util.List;

public class ExceptionHandler {

    public static void checkOutOfRange(List<Integer> numbers) throws IllegalArgumentException {
        if (numbers.get(0) < 1 || numbers.get(numbers.size() - 1) > 45) {
            throw new IllegalArgumentException(Error.OUT_OF_RANGE.getMessage());
        }
    }

    public static void checkOutOfRange(int number) throws IllegalArgumentException {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(Error.OUT_OF_RANGE.getMessage());
        }
    }
}
