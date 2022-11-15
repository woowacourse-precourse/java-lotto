package lotto;

import java.util.List;

public class Lotto {
    public static final int PRICE = 1000;
    public static final int START_RANGE = 1;
    public static final int END_RANGE = 45;
    public static final int NUMBER_COUNT = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException(ErrorType.NUMBER_COUNT.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
