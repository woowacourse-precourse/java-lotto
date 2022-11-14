package ExceptionCollections;

import java.util.List;

public class LottoException {
    public static void validate(List<Integer> numbers) {
        checkLength(numbers);
        checkDuplicate(numbers);
        checkOrder(numbers);
        checkRange(numbers);
    }

    private static void checkDuplicate(List<Integer> numbers) {
        for (int numberIndex = 0; numberIndex < numbers.size(); numberIndex++) {
            if (numbers.lastIndexOf(numbers.get(numberIndex)) != numberIndex) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void checkLength(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
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

    private static void checkRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException();
            }
        }
    }
}
