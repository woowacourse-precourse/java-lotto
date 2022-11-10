package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {

    private static final Integer SIZE = 6;

    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    private static void validate(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException();
        }

        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private static boolean isDuplicated(List<Integer> numbers) {
        Set<Integer> uniqueNumbers = new HashSet<>();

        for (Integer number : numbers) {
            uniqueNumbers.add(number);
        }

        return !(uniqueNumbers.size() == numbers.size());
    }

    public static Lotto numberOf(List<Integer> numbers) {
        validate(numbers);

        return new Lotto(numbers);
    }
}
