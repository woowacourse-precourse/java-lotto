package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validator.validate(numbers);
        this.numbers = numbers;
    }

    public Integer get(int index) {
        return numbers.get(index);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
