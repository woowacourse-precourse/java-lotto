package lotto.model;

import java.util.List;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        sizeValidate(numbers);
        overlapValidate(numbers);
    }

    private void sizeValidate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void overlapValidate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 0) {
            throw new IllegalArgumentException();
        }
    }
    // TODO: 추가 기능 구현
}
