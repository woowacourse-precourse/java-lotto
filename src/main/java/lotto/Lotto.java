package lotto;

import exception.DuplicateInputException;
import exception.InputSizeException;
import exception.OutOfRangeInputException;

import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        HashSet<Integer> dupRemovedNumbers = new HashSet<>(numbers);
        if (numbers.size() != 6) {
            throw new InputSizeException();
        }

        if (dupRemovedNumbers.size() != 6) {
            throw new DuplicateInputException();
        }

        if (Collections.min(numbers) < 1 || Collections.max(numbers) > 45) {
            throw new OutOfRangeInputException();
        }

    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
