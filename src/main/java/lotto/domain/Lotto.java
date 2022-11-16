package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        Validator.validate(numbers);
    }

    public Integer get(int index) {
        return numbers.get(index);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
