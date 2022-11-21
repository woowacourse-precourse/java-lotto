package lotto.model;

import static lotto.controller.ExceptionHandler.validNumbersDupplication;
import static lotto.controller.ExceptionHandler.validNumbersLength;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validNumbersLength(numbers);
        validNumbersDupplication(numbers);
        this.numbers = numbers;
    }

    public List<Integer> numbers(){ return numbers; }

}
