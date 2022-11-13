package lotto.Model;

import lotto.Error;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Error.OVER_NUMBER_COUNT.getMessage());
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(Error.DUPLICATE_LOTTO_NUMBER.getMessage());
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }
}
