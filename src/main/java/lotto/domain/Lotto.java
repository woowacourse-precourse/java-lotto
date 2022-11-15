package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator.validate(numbers);
        this.numbers = numbers.stream().sorted().collect(Collectors.toList());
    }

    public Integer get(int index) {
        return numbers.get(index);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
