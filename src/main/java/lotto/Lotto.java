package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        ascending(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoException exception;
        if (numbers.size() != 6) {
            exception = LottoException.valueOf("SIZE_EXCEPTION");
            throw new IllegalArgumentException(exception.getMessage());
        }
        if (new HashSet<>(numbers).size() != numbers.size()) {
            exception = LottoException.valueOf("DUPLICATE_EXCEPTION");
            throw new IllegalArgumentException(exception.getMessage());
        }
    }

    public void ascending(List<Integer> numbers) {
        Collections.sort(numbers);
    }
}