package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.util.Validation;

public class Lotto {
    private final int LOTTO_PRICE = 1000;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Validation.isDuplicated(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return this.numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }
}
