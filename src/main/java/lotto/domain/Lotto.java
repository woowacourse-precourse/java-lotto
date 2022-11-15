package lotto.domain;

import lotto.type.ErrorType;

import java.util.HashSet;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        hasDuplicateNumber(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorType.OVER_SIZE.getError());
        }
    }

    // TODO: 추가 기능 구현
    private void hasDuplicateNumber(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);

        if (numbers.size() > uniqueNumbers.size())
            throw new IllegalArgumentException(ErrorType.DUPLICATE_NUMBER.getError());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
