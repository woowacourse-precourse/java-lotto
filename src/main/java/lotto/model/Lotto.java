package lotto.model;

import lotto.util.InputValidator;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers  = new ArrayList<>(numbers);
        this.numbers.sort((o1,o2)->{return o1-o2;});
    }

    private void validate(List<Integer> numbers) {
        InputValidator.validateLotto(numbers);
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
}
