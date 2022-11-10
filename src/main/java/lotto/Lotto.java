package lotto;

import java.util.List;

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
    }

    public static Lotto numberOf(List<Integer> numbers) {
        validate(numbers);

        return new Lotto(numbers);
    }
}
