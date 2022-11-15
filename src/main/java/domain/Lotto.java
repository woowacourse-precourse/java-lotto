package domain;

import exception.LottoException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }
    private void validateDuplicate(List<Integer> numbers) {
        LottoException.lottoDuplicate(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public String toString() {
        Collections.sort(numbers);
        return numbers.toString();
    }
}
