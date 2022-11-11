package lotto;

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
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException();
        }
        if (Collections.min(numbers) < 1 || 45 < Collections.max(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    public void add(Integer number) {
        numbers.add(number);
    }

    // TODO: 추가 기능 구현
}
