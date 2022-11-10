package lotto;

import java.util.List;

public class Lotto {

    private static final Integer SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
}
