package lotto.domain;

import lotto.utils.Validation;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Validation.validate(numbers);
        this.numbers = numbers;
    }

    public int getNumber(int index) {
        return numbers.get(index);
    }
}
