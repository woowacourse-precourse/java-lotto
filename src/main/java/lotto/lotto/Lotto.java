package lotto.lotto;

import lotto.Exception.Exception;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        isValid(numbers);
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

    public List<Integer> getNumbers() {
        return numbers;
    }

    // TODO: 추가 기능 구현
}
