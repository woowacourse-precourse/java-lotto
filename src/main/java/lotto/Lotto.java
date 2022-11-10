package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.NUMBER_OUT_OF_RANGE);
        }
    }

    public void print() {
        System.out.println(numbers);
    }
}
