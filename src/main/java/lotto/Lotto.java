package lotto;

import java.util.List;

public class Lotto {
    private final List<Number> numbers;

    public Lotto(List<Number> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Number> numbers) {
        Validator validator = new Validator();
        validator.throwIfNotUnique(numbers);
        validator.throwIfNotSix(numbers);
    }

    // TODO: 추가 기능 구현
}
