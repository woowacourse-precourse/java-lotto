package lotto.domain;

import java.util.List;

public class Lotto {
    private final static Validation validator = new Validation();

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validator.validateBasicNumber(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getLotto() {
        return numbers;
    }
}
