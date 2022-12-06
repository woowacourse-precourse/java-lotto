package lotto;

import lotto.Exception.Exception;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        isValid(numbers);
        sortNumbers(numbers);
        this.numbers = numbers;
    }

    private void isValid(List<Integer> numbers) {
        validateSize(numbers);
        isNotDup(numbers);
        isValidRange(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        Exception.checkSize(numbers);
    }

    private void isNotDup(List<Integer> numbers) {
        Exception.checkDup(numbers);
    }

    private void isValidRange(List<Integer> numbers) {
        Exception.checkRange(numbers);
    }

    private void sortNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
