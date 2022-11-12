package lotto.service;

import lotto.handler.InputMoneyHandler;
import java.util.Collections;
import java.util.List;

import static lotto.service.PickRandomLotto.randomLottoLists;

public class Lotto {
    private final List<Integer> numbers;
    InputMoneyHandler inputMoneyHandler = new InputMoneyHandler();
    PickRandomLotto pickRandomLotto = new PickRandomLotto();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        checkSameNumbers(numbers);
        sortedLottoNumbers(numbers);
        this.numbers = numbers;
    }

    private void checkSameNumbers(List<Integer> numbers) {
        if(numbers.stream().distinct().count() == pickRandomLotto.LIMIT_LOTTO) {
            randomLottoLists.add(numbers);
        }
        if(numbers.stream().distinct().count() != pickRandomLotto.LIMIT_LOTTO) {
            throw new IllegalArgumentException(inputMoneyHandler.ERROR_ORDER);
        }
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