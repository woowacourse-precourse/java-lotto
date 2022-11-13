package lotto;

import static lotto.LottoNumberRange.*;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateRange(numbers);
        validateDuplication(numbers);
        ascendingOrder(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void validateRange(List<Integer> numbers) {
        int minRange = MIN.getValue();
        int maxRange = MAX.getValue();

        boolean isOverRange = numbers.stream()
                .anyMatch(number -> !(minRange <= number && number <= maxRange));
        if (isOverRange) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    private void ascendingOrder(List<Integer> numbers) {
        Collections.sort(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
