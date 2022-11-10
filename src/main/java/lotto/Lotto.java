package lotto;

import java.util.*;

public class Lotto {
    public static final int MIN_NUMBER = 1;
    public static final int MAX_NUMBER = 45;
    public static final int LOTTO_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        isValidCount(numbers);
        isValidNumber(numbers);
        hasDistinctNumbers(numbers);
    }

    private static void isValidNumber(List<Integer> numbers) {
        Optional<Integer> result = numbers.stream()
                .filter(number -> number < MIN_NUMBER || number > MAX_NUMBER)
                .findFirst();

        if (result.isPresent()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER.getValue());
        }
    }

    private static void isValidCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_COUNT) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COUNT.getValue());
        }
    }

    private static void hasDistinctNumbers(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.HAVE_DUPLICATED_NUMBER.getValue());
        }
    }
}
