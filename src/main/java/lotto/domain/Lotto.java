package lotto.domain;

import lotto.exception.InputException;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;
    InputException inputException = new InputException();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        isDuplicateNumber(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void isDuplicateNumber(List<Integer> numbers) {
        inputException.duplicateNumberException(numbers);
    }
}
