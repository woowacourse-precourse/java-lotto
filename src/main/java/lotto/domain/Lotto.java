package lotto.domain;

import static lotto.utils.Constant.NUMBER_OF_LOTTO;

import java.util.HashSet;
import java.util.List;
import lotto.utils.ExceptionType;
import lotto.view.Output;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateBySize(numbers);
        validateByRange(numbers);
    }

    private void validateBySize(List<Integer> numbers) {
        if (numbers.size() != NUMBER_OF_LOTTO) {
            throw new IllegalArgumentException();
        }
    }

    private void validateByRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            inLottoRange(number);
        }
    }

    private void inLottoRange(int number) {
        if (number < 1 || number > 45) {
            Output.printErrorAndExit(ExceptionType.NOT_WITHIN_THE_RANGE.getMessage());
            throw new IllegalArgumentException(ExceptionType.NOT_WITHIN_THE_RANGE.getMessage());
        }
    }

    public void addNumber(int number) {
        this.numbers.add(number);
    }

    // TODO: 추가 기능 구현
}
