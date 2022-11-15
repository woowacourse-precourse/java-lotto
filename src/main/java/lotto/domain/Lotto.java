package lotto.domain;

import lotto.exception.Check;
import lotto.exception.CustomException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicate(numbers);
        range(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(CustomException.VALIDATE.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    private void duplicate(List<Integer> numbers) {
        Check check = new Check();
        if (!check.checkDuplicate(numbers)) {
            throw new IllegalArgumentException(CustomException.DUPLICATE.getMessage());
        }
    }

    private void range(List<Integer> numbers) {
        Check check = new Check();
        if (!check.checkRange(numbers)) {
            throw new IllegalArgumentException(CustomException.RANGE.getMessage());
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public Lotto ascendingSort() {
        List<Integer> sortNumbers = new ArrayList<>(numbers);
        Collections.sort(sortNumbers);
        return new Lotto(sortNumbers);
    }
}
