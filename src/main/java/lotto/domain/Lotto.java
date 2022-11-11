package lotto.domain;

import lotto.constant.LottoRule;
import lotto.exception.DuplicateLottoNumberException;
import lotto.exception.LottoNumberOutOfBoundException;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }

        numbers.forEach(this::validateRangeOfNumber);
        validateNotDuplicate(numbers);
    }

    private void validateRangeOfNumber(int number) {
        if (number > LottoRule.MAXIMUM_NUMBER.getValue()
                || number < LottoRule.MINIMUM_NUMBER.getValue()) {
            throw new LottoNumberOutOfBoundException();
        }
    }

    private void validateNotDuplicate(List<Integer> numbers) {
        for (int index = 0; index < numbers.size() - 1; index++) {
            isDuplicate(numbers.get(index), numbers.get(index + 1));
        }
    }

    private void isDuplicate(int numberToCompare, int numberWithNext) {
        if (numberToCompare == numberWithNext) {
            throw new DuplicateLottoNumberException();
        }
    }

    private void countMatchedNumber(WinningLotto winningLotto) {

    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public String toString() {
        return numbers.toString();
    }
}
