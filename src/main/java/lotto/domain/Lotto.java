package lotto.domain;

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

    public boolean contains(Object value) {
        return numbers.contains(value);
    }

    public int get(Object index) {
        return numbers.get((Integer) index);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
