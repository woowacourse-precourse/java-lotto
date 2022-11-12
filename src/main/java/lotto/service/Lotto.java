package lotto.service;

import lotto.handler.InputMoneyHandler;

import java.util.Collections;
import java.util.List;

public class Lotto {
    InputMoneyHandler inputMoneyHandler = new InputMoneyHandler();
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        sortedLottoNumbers(numbers);
        this.numbers = numbers;
    }

    private List<Integer> sortedLottoNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(inputMoneyHandler.ERROR_ORDER);
        }
    }
}