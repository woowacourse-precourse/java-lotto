package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int SMALLEST_LOTTERY_NUMBER = 1;
    private static final int BIGGEST_LOTTERY_NUMBER = 45;
    private static final int LOTTERY_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validateNumberRange(List<Integer> numbers) {
        int i = 0;
        int size = numbers.size() - 1;
        int currentElement = numbers.get(i);

        while (i < size && (SMALLEST_LOTTERY_NUMBER <= currentElement && currentElement <= BIGGEST_LOTTERY_NUMBER)) {
            currentElement = numbers.get(i++);
        }
        if (i != size) {
            throw (new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_EXCEPTION
                    .toString()));
        }
    }

    private void validateUniqueness(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != LOTTERY_NUMBER_COUNT) {
            throw (new IllegalArgumentException(ExceptionMessage.WINNING_NUMBER_EXCEPTION
                    .toString()));
        }
    }

    private void validate(List<Integer> numbers) {
        validateNumberRange(numbers);
        validateUniqueness(numbers);
    }

}
