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

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        if (!isValidSize(numbers)) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
        if(isDuplicated(numbers)) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않아야 합니다.");
        }
        if(isNotValidRange(numbers)) {
            throw new IllegalArgumentException("로또 번호는 1부터 45 사이의 숫자여야 합니다.");
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
