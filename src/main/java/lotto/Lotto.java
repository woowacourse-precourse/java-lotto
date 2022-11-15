package lotto;

import static lotto.util.Validator.validatePlayNumbersCount;
import static lotto.util.Validator.validatePlayNumbersDuplication;
import static lotto.util.Validator.validatePlayNumbersRange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
        numbers = ascendingOrder(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validatePlayNumbersCount(numbers);
    }

    // TODO: 추가 기능 구현
    private void validateRange(List<Integer> numbers) {
        validatePlayNumbersRange(numbers);
    }

    private void validateDuplication(List<Integer> numbers) {
        validatePlayNumbersDuplication(numbers);
    }

    private List<Integer> ascendingOrder(List<Integer> numbers) {
        numbers = new ArrayList<>(numbers);
        Collections.sort(numbers);
        return numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
