package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private void duplicate(List<Integer> numbers) {
    }

    private void range(List<Integer> numbers) {
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public void ascendingSort() {
        Collections.sort(numbers);
    }
}
