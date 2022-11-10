package lotto;

import org.mockito.internal.matchers.Null;

import java.util.List;

public class Lotto {
    private static final int MAX_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (!isValidSize(numbers)) {
            throw new IllegalArgumentException();
        }
        if(isDuplicated(numbers)) {
            throw new IllegalArgumentException();
        }
        if(isNotValidRange(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    static boolean isValidSize(List<Integer> numbers) {
        return numbers.size() == MAX_SIZE;
    }

    static boolean isDuplicated(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    static boolean isNotValidRange(List<Integer> numbers) {
        return numbers.stream().filter(n -> n < 1 || n > 45).findFirst().isPresent();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
