package ExceptionCollections;

import java.util.List;

public class LottoException extends CommonException {
    public static void validate(List<Integer> numbers) {
        validateNumberLength(numbers);
        checkOrder(numbers);
        for (Integer number : numbers) {
            hasDuplicatedNumber(numbers, number);
            validateNumberRange(number);
        }
    }

    private static void checkOrder(List<Integer> numbers) {
        int previousNumber = 0;
        for (Integer number : numbers) {
            if (previousNumber > number) {
                throw new IllegalArgumentException();
            }
            previousNumber = number;
        }
    }
}
