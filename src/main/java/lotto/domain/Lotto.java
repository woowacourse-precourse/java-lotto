package lotto.domain;

import lotto.utils.Error;
import lotto.utils.ErrorException;

import java.util.List;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateNumbers(numbers);
        this.numbers = numbers;
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new ErrorException(Error.INVALID_LOTTO_SIZE.toString());
        }
    }

    // TODO: 추가 기능 구현
}