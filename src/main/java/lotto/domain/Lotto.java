package lotto.domain;

import lotto.exception.LottoException;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6)
            throw new IllegalArgumentException(LottoException.INVALID_NUMBER_COUNT.getErrorMessage());

        for (int number : numbers) {
            if (number > 45 || number < 1)
                throw new IllegalArgumentException(LottoException.INVALID_NUMBER_RANGE.getErrorMessage());
        }

        if (numbers.size() != numbers.stream().distinct().count())
            throw new IllegalArgumentException(LottoException.DUPLICATED.getErrorMessage());
    }

}
