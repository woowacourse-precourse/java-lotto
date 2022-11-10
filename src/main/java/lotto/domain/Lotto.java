package lotto.domain;

import java.util.List;

import lotto.constant.LottoStatistic;
import lotto.exception.ExceptionHandler;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        ExceptionHandler.isListCorrectSize(numbers, LottoStatistic.NUMBER_OF_LOTTERY_NUMBERS.getValue());
        ExceptionHandler.doesContainDuplicate(numbers);
    }

    public String getNumbersAsString() {
        return numbers.toString();
    }
}
