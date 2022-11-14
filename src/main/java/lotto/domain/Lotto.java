package lotto.domain;

import lotto.exception.InputException;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;
    InputException inputException = new InputException();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        isDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public void printNumbers() {
        System.out.println(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public boolean isDuplicateNumber(List<Integer> numbers) {
        inputException.duplicateNumberException(numbers);
        return false;
    }
}
