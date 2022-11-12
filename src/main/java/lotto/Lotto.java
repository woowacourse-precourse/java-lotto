package lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        new Validation(numbers);
    }

    // TODO: 추가 기능 구현
    public List<Integer> getLotto() {
        return numbers;
    }
}
