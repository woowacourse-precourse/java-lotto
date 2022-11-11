package lotto;

import java.util.List;
import java.util.stream.Collectors;

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
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ExceptionMessage.ERROR + ExceptionMessage.DUPLICATE_NUMBER);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void print() {
        System.out.println(numbers.stream()
                .sorted()
                .collect(Collectors.toList()));
    }
}
